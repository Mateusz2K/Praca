package repozytorium;

import zarzadzanieFinansami.magazyn.MagazynUzytkownika;
import zarzadzanieFinansami.modele.Uzytkownik;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test") // Jeśli masz zdefiniowane profile testowe
@EnableJpaRepositories(basePackages = "magazyn") // Skanowanie repozytoriów
public class MagazynUzytkownikaTest {

    @MockBean
    private MagazynUzytkownika magazynUzytkownika;

    @Test
    public void saveTest() {
        Uzytkownik nowyUzytkownik = new Uzytkownik();
        nowyUzytkownik.setEmail("test@test.com");
        nowyUzytkownik.setName("Testowy Użytkownik");
        magazynUzytkownika.save(nowyUzytkownik);

        // Assert, czy encja została zapisana
        assertTrue(magazynUzytkownika.existsById(nowyUzytkownik.getId()));
    }
}
