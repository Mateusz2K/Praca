package zarzadzanieFinansami.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @NotBlank(message = "Nazwa nie może być pusta")
    private String nazwa;
    @NotBlank(message = "Hasło nie może być puste")
    private String password;

    // Gettery

    public String getNazwa() {
        return nazwa;
    }


    public String getPassword() {
        return password;
    }

    // Settery (opcjonalne, jeśli używasz konstruktora lub deserializacji przez framework)

    public void setPassword(String password) {
        this.password = password;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}