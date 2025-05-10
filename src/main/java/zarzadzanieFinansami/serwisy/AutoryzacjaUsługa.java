//package serwisy;
//
//import magazyn.MagazynUzytkownika;
//import modele.Uzytkownik;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import token.GeneracjaTokenu;
//
//import java.util.Optional;
//
//@Service
//public class AutoryzacjaUsługa {
//
//    private final MagazynUzytkownika magazynUzytkownika; // Repozytorium z użytkownikami
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public AutoryzacjaUsługa(MagazynUzytkownika magazynUzytkownika) {
//        this.magazynUzytkownika = magazynUzytkownika;
//        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    }
//
//    public String autoryzacja(String email, String haslo) {
//        // Wyszukanie użytkownika po emailu
//        Optional<Uzytkownik> userOpt = magazynUzytkownika.findByEmail(email);
//        Uzytkownik user = userOpt.orElseThrow(() -> new RuntimeException("Niepoprawny email lub hasło"));
//
//        // Sprawdzenie liczby nieudanych prób logowania
//        if (user.getBłędneLogowanie() >= 5) {
//            //TODO:dodać za pomocą wartości jestAktywny zablokować uzytkownika
//            throw new RuntimeException("Twoje konto zostało zablokowane po 5 błędnych próbach logowania.");
//        }
//
//        // Sprawdzenie hasła
//        if (!bCryptPasswordEncoder.matches(haslo, user.getHaslo())) {
//            // Zwiększ liczbę błędnych prób logowania
//            user.dodajBłędneLogowanie();
//            magazynUzytkownika.save(user); // Aktualizacja użytkownika w bazie
//            throw new RuntimeException("Niepoprawny email lub hasło");
//        }
//
//        // Zresetuj liczbę prób logowania po poprawnym logowaniu
//        user.resetBłędneLogowanie();
//        magazynUzytkownika.save(user); // Zapisanie zmian w bazie (reset prób)
//
//        // Wygeneruj token JWT lub inny token autoryzacyjny
//        return wygenerujToken(user);
//    }
//
////    private String wygenerujToken(Uzytkownik user) {
////        // Logika generowania tokenu (np. JWT)
////        return GeneracjaTokenu.generateToken(user.getEmail()); // Tutaj dodaj swoje rzeczywiste generowanie tokenu
////    }
//}

