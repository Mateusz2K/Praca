package SerwisTest;

import magazyn.MagazynUzytkownika;
import modele.Uzytkownik;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import serwisy.UzytkownikUsługa;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UzytkownikServiceTest {

    @Mock
    private MagazynUzytkownika magazynUzytkownika;

    @InjectMocks
    private UzytkownikUsługa uzytkownikUsługa; // Klasa, w której jest metoda znajdzUzytkownikPrzezEmail

    @Test
    public void testZnajdzUzytkownikPrzezEmail_ZnalezionoUzytkownika() {
        // Arrange
        String email = "test@example.com";
        Uzytkownik expectedUzytkownik = new Uzytkownik(); // Zastąp odpowiednim konstruktorem lub setterami
        expectedUzytkownik.setEmail(email);

        when(magazynUzytkownika.findByEmail(email)).thenReturn(Optional.of(expectedUzytkownik));

        // Act
        Uzytkownik result = uzytkownikUsługa.znajdzUzytkownikPrzezEmail(email);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(magazynUzytkownika, times(1)).findByEmail(email);
    }

    @Test
    public void testZnajdzUzytkownikPrzezEmail_NieZnalezionoUzytkownika() {
        // Arrange
        String email = "notfound@example.com";

        when(magazynUzytkownika.findByEmail(email)).thenReturn(Optional.empty());

        // Act
        Uzytkownik result = uzytkownikUsługa.znajdzUzytkownikPrzezEmail(email);

        // Assert
        assertNull(result);
        verify(magazynUzytkownika, times(1)).findByEmail(email);
    }
}