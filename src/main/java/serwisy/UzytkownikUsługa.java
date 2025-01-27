package serwisy;

import DTO.UzytkownikDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import magazyn.MagazynUzytkownika;
import magazyn.MagazynUzytkownikaDodatek;
import modele.Uzytkownik;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UzytkownikUsługa implements MagazynUzytkownikaDodatek {

    private final MagazynUzytkownika magazynUzytkownika;
    @PersistenceContext
    private EntityManager entityManager;

    public UzytkownikUsługa(MagazynUzytkownika magazynUzytkownika) {
        this.magazynUzytkownika = magazynUzytkownika;
    }
    public UzytkownikDTO stworzUzytkownika(UzytkownikDTO dto){
            if (dto.getNazwa() == null || dto.getNazwa().isEmpty() || dto.getEmail() == null || dto.getEmail().isEmpty() || dto.getHaslo() == null || dto.getHaslo().isEmpty()) {
            throw new IllegalArgumentException("Wszystkie pola muszą być wypełnione");
        }
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setName(dto.getNazwa());
        uzytkownik.setEmail(dto.getEmail());
        uzytkownik.setHasło(dto.getHaslo());
        Uzytkownik zapisany = magazynUzytkownika.save(uzytkownik);
        return new UzytkownikDTO(zapisany.getName(), zapisany.getEmail(), zapisany.getHasło());
    }
    public void usunUzytkownika(int id){
        Uzytkownik uzytkownik = magazynUzytkownika.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Użytkownik o ID " + id + " nie istnieje"));
        magazynUzytkownika.delete(uzytkownik);
    }

    @Override
    public Uzytkownik znajdzUzytkownikPrzezEmail(String email) {
        Optional<Uzytkownik> uzytkownik = magazynUzytkownika.findByEmail(email);
        return uzytkownik.orElse(null);
    }

    public Uzytkownik znajdzUrzytkownikaPrzezId(int id){
        return magazynUzytkownika.findById(id).orElse(null);
    }


}

