package DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UzytkownikDTO{
        @NotBlank(message = "Nazwa użytkownika nie może być pusta")
        @Size(min = 3, max = 50, message = "Nazwa użytkownika musi mieć od 3 do 50 znaków")
        private String nazwa;
        @NotBlank(message = "Email nie może być pusty")
        @Email(message = "Nieprawidłowy format email")
        private String email;
        @NotBlank(message = "Hasło nie może być puste")
        @Size(min = 6, message = "Hasło musi mieć co najmniej 6 znaków")
        private String haslo;

        public UzytkownikDTO(String nazwa, String email, String haslo) {
                this.nazwa = nazwa;
                this.email = email;
                this.haslo = haslo;
        }

        public UzytkownikDTO(String haslo, String nazwa) {
                this.haslo = haslo;
                this.nazwa = nazwa;
        }

        public String getNazwa() {
                return nazwa;
        }

        public void setNazwa(String nazwa) {
                this.nazwa = nazwa;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getHaslo() {
                return haslo;
        }

        public void setHaslo(String haslo) {
                this.haslo = haslo;
        }
}
