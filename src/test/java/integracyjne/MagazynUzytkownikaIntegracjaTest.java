package integracyjne;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import zarzadzanieFinansami.modele.Uzytkownik;
import zarzadzanieFinansami.magazyn.MagazynUzytkownika;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@SpringBootTest
@Transactional
public class MagazynUzytkownikaIntegracjaTest {
    @Autowired
    private MagazynUzytkownika magazynUzytkownika;

    @Test
    public void testFindByEmail() {
        // Zapisujemy użytkownika do bazy
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setEmail("test@test.com");
        uzytkownik.setName("Testowy Użytkownik");

        magazynUzytkownika.save(uzytkownik);

        // Sprawdzamy, czy użytkownik został zapisany
        Optional<Uzytkownik> result = magazynUzytkownika.findByEmail("test@test.com");

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Testowy Użytkownik", result.get().getName());
    }

}
