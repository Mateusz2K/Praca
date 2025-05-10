//package SerwisTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import DTO.CelDTO;
//import magazyn.MagazynCelu;
//import magazyn.MagazynKonta;
//import modele.Cel;
//import modele.Konto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import jakarta.persistence.EntityNotFoundException;
//import serwisy.CelUsługa;
//
//@ExtendWith(MockitoExtension.class)
//class CelUsługaTest {
//
//    @Mock
//    private MagazynKonta magazynKonta;
//
//    @Mock
//    private MagazynCelu magazynCelu;
//
//    @InjectMocks
//    private CelUsługa celUsługa;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testDodajCel() {
//        // Przygotowanie danych
//        CelDTO celDTO = new CelDTO("Test Cel", new BigDecimal("1000.00"), new BigDecimal("100.00"), LocalDateTime.now(), 1);
//        Konto konto = new Konto();
//
//        // Definiowanie zachowania mocka
//        when(magazynKonta.getReferenceById(celDTO.idKonto())).thenReturn(konto);
//
//        // Wywołanie testowanej metody
//        celUsługa.dodajCel(celDTO);
//
//        // Weryfikacja
//        verify(magazynCelu, times(1)).save(any(Cel.class));
//    }
//
//    @Test
//    void testZnajdzCelPrzezId() {
//        // Przygotowanie danych
//        Cel cel = new Cel("Test Cel", new BigDecimal("1000.00"), new BigDecimal("100.00"), LocalDateTime.now(), new Konto());
//
//        // Definiowanie zachowania mocka
//        when(magazynCelu.findById(1)).thenReturn(Optional.of(cel));
//
//        // Wywołanie testowanej metody
//        Cel foundCel = celUsługa.znajdzCel(1);
//
//        // Asercje
//        assertNotNull(foundCel);
//        assertEquals("Test Cel", foundCel.getNazwa());
//    }
//
//    @Test
//    void testZnajdzCelPrzezId_NotFound() {
//        // Definiowanie zachowania mocka
//        when(magazynCelu.findById(1)).thenReturn(Optional.empty());
//
//        // Weryfikacja, czy metoda wyrzuci wyjątek
//        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
//            celUsługa.znajdzCel(1);
//        });
//
//        // Asercja treści komunikatu błędu
//        assertEquals("Cel o ID 1 nie istnieje", exception.getMessage());
//    }
//}