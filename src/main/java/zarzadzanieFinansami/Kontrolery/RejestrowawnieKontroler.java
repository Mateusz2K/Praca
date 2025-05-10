package zarzadzanieFinansami.Kontrolery;

// import zarzadzanieFinansami.DTO.UzytkownikDTO; // Niepotrzebny import
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired; // Można usunąć
import org.springframework.http.HttpStatus; // Dodaj ten import
import org.springframework.http.ResponseEntity; // Dodaj ten import
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zarzadzanieFinansami.modele.Uzytkownik;
import zarzadzanieFinansami.serwisy.UzytkownikUsluga;
// import java.net.URI; // Potrzebne dla ResponseEntity.created

@RestController
@RequestMapping("/api")
public class RejestrowawnieKontroler {

    // @Autowired // Ta adnotacja jest zbędna przy wstrzykiwaniu przez konstruktor
    private final UzytkownikUsluga uzytkownikUsluga;

    // Wstrzykiwanie przez konstruktor - bardzo dobrze
    public RejestrowawnieKontroler(UzytkownikUsluga uzytkownikUsluga) {
        this.uzytkownikUsluga = uzytkownikUsluga;
    }

    @PostMapping("/rejestr")
    // Zwracanie ResponseEntity daje większą kontrolę nad odpowiedzią HTTP
    public ResponseEntity<Void> rejestruj(@Valid @RequestBody Uzytkownik uzytkownik){
        // Wywołanie serwisu jest poprawne zgodnie z jego nową sygnaturą
        // Zakłada, że obiekt 'uzytkownik' z @RequestBody zawiera surowe hasło w polu 'haslo'
        uzytkownikUsluga.stworzUzytkownika(uzytkownik.getName(), uzytkownik.getEmail(), uzytkownik.getHaslo());

        // Dobrą praktyką jest zwrócenie statusu 201 Created po pomyślnym utworzeniu zasobu
        // Można też dodać nagłówek Location wskazujący na nowo utworzony zasób, ale wymaga to endpointu GET
        return ResponseEntity.status(HttpStatus.CREATED).build();
        // Alternatywnie, jeśli chcesz zwrócić np. ID:
        // Uzytkownik stworzony = uzytkownikUsluga.stworzUzytkownika(...);
        // return ResponseEntity.status(HttpStatus.CREATED).body(stworzony.getId()); // Zwraca tylko ID
    }
}