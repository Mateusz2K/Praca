package zarzadzanieFinansami.Kontrolery;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zarzadzanieFinansami.DTO.KontoResponseDTO;
import zarzadzanieFinansami.DTO.KontoTworzenieDTO;
import zarzadzanieFinansami.magazyn.MagazynUzytkownika;
import zarzadzanieFinansami.modele.Konto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zarzadzanieFinansami.modele.Uzytkownik;
import zarzadzanieFinansami.modele.enumeracje.TypKontaEnum;
import zarzadzanieFinansami.modele.enumeracje.WalutaEnum;
import zarzadzanieFinansami.serwisy.KontoUsługa;
import zarzadzanieFinansami.serwisy.UzytkownikUsluga;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/konta")
@RestController
public class KontoKontroler {

    private final KontoUsługa kontoUsluga;
    private final MagazynUzytkownika magazynUzytkownika;
    private final UzytkownikUsluga uzytkownikUsluga;

    public KontoKontroler(KontoUsługa kontoUsluga, MagazynUzytkownika magazynUzytkownika, UzytkownikUsluga uzytkownikUsluga) {
        this.kontoUsluga = kontoUsluga;
        this.magazynUzytkownika = magazynUzytkownika;
        this.uzytkownikUsluga = uzytkownikUsluga;
    }

    @GetMapping("/konto")
    @ResponseStatus(HttpStatus.OK)
    public List<Konto> getKonta(){
        return kontoUsluga.znajdzWszystkieKonta();
    }
    @GetMapping("/konto/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getKonto(@PathVariable int id, Authentication auth){
        Optional<Konto> kontoOpt = kontoUsluga.znajdzKontoPrzezId(id);
        if(kontoOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Konto konto = kontoOpt.get();
        // 3. Sprawdzenie autoryzacji (czy użytkownik jest właścicielem lub adminem)
        String loggedInUserEmail = auth.getName(); // Pobierz identyfikator zalogowanego użytkownika (zakładając, że to email)
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        // Sprawdź, czy użytkownik jest adminem LUB czy email właściciela konta pasuje do zalogowanego użytkownika
        // UWAGA: konto.getUzytkownik() może wymagać otwartej sesji Hibernate, jeśli jest LAZY.
        // Rozważ dodanie metody w serwisie, która sprawdza to wydajniej.
        if (!isAdmin && (konto.getUzytkownik() == null || !konto.getUzytkownik().getEmail().equals(loggedInUserEmail))) {
            // Jeśli użytkownik nie jest adminem i nie jest właścicielem konta
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Brak uprawnień do wyświetlenia tego konta."); // Zwróć 403
        }

        // 4. Jeśli autoryzacja przeszła pomyślnie, zmapuj encję na DTO
        KontoResponseDTO kontoDto = mapToDto(konto); // Użyj metody mapującej

        // 5. Zwróć DTO w odpowiedzi z kodem 200 OK
        return ResponseEntity.ok(kontoDto);}
    @PostMapping(path = "/nowe")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> stworzKonto(@Valid @RequestBody KontoTworzenieDTO kontoDTO, Authentication auth){
        String userName = auth.getName();
        Uzytkownik uzytkownik = magazynUzytkownika.findByNazwa(userName);
        if(uzytkownik == null){
            // Ten przypadek nie powinien wystąpić, jeśli @PreAuthorize("isAuthenticated()") działa poprawnie
            // i UserDetailsService zwraca poprawne dane.
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nie można zidentyfikować zalogowanego użytkownika.");
        }
        try{
            Konto stworzoneKonto = kontoUsluga.stworzenieKontoDlaUzytkownika(kontoDTO, uzytkownik);
            KontoResponseDTO kontoDto = mapToDto(stworzoneKonto);

            URI locatoion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(kontoDto.getId()).toUri();
            return ResponseEntity.created(locatoion).body(kontoDto);
        } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage()); // Np. błąd walidacji, duplikat nazwy
        } catch (Exception e) {
        // Loguj błąd po stronie serwera
        // logger.error("Błąd podczas tworzenia konta: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wystąpił nieoczekiwany błąd podczas tworzenia konta.");
        }
    }
    @GetMapping("/moje")
    public ResponseEntity<?> pobierzMojeKonta(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Użytkownik nie jest uwierzytelniony.");
        }
        String nazwaUzytkownika = authentication.getName();
        Uzytkownik uzytkownikWeryfikacja = uzytkownikUsluga.znajdzUrzytkownikaPrzezNazwe(nazwaUzytkownika );
        try {
            List<Konto> konta = kontoUsluga.znajdzKontaDlaUzytkownika(uzytkownikWeryfikacja);
            List<KontoResponseDTO> kontoResponseDTOList = konta.stream().map(this::mapToDto).toList();
            return ResponseEntity.ok(kontoResponseDTOList);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/konto/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean usunKonto(@PathVariable int id){
        if (kontoUsluga.znajdzKontoPrzezId(id).isPresent()){
            kontoUsluga.usunKonto(kontoUsluga.znajdzKontoPrzezId(id).get());
            return true;
        }
        else {
            return false;
        }
    }
    @PutMapping("/konto/{id}")
    public Konto updateKonto(@PathVariable int id, @RequestBody Konto newKonto){
        if (kontoUsluga.znajdzKontoPrzezId(id).isPresent()){
            return kontoUsluga.updateKonto(kontoUsluga.znajdzKontoPrzezId(id).get(), newKonto);
        }
        return null;
    }
    private KontoResponseDTO mapToDto(Konto konto) {
        if (konto == null) {
            return null;
        }
        // Stwórz i zwróć DTO, przekazując tylko potrzebne i bezpieczne dane
        return new KontoResponseDTO(
                konto.getId(),
                konto.getNazwa(),
                konto.getBilans(),
                konto.getTyp().name(), // Przekaż nazwę enuma jako String
                konto.getWaluta().name(), // Przekaż nazwę enuma jako String
                konto.getDataUtworzenia(),
                konto.getUzytkownik() != null ? konto.getUzytkownik().getId() : null // Przekaż tylko ID użytkownika
        );
    }

}
