package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.Uzytkownik;

public interface MagazynUzytkownikaDodatek {
    Uzytkownik znajdzUzytkownikPrzezEmail(String email);
    boolean checkPassword(String email, String password);
    boolean existsByEmail(String email);
}
