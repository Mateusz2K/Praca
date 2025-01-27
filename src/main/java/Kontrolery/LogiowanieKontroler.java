package Kontrolery;

import DTO.UzytkownikDTO;
import DTO.LoginOdpowiedzDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import token.GeneracjaTokenu;

@RestController
@RequestMapping("api/login")
public class LogiowanieKontroler {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UzytkownikDTO request) {
        // Weryfikuj użytkownika w bazie danych
        if (request.getNazwa().equals("admin") && request.getHaslo().equals("password")) {
            String token = GeneracjaTokenu.generateToken(request.getNazwa());
            return ResponseEntity.ok(new LoginOdpowiedzDTO(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nieprawidłowe dane logowania");
    }
}
