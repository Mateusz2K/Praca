package zarzadzanieFinansami.serwisy;

import zarzadzanieFinansami.magazyn.MagazynUzytkownika;
import zarzadzanieFinansami.modele.SzczegolyUzytkownika;
import zarzadzanieFinansami.modele.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetaleUzytkownikówSerwis implements UserDetailsService {


    private MagazynUzytkownika magazynUzytkownika;

    @Autowired
    public DetaleUzytkownikówSerwis(MagazynUzytkownika magazynUzytkownika) {
        this.magazynUzytkownika = magazynUzytkownika;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Uzytkownik uzytkownik = magazynUzytkownika.findByNazwa(username);

        if (uzytkownik == null) {
            throw new UsernameNotFoundException("not found: " + username);
        }

        return new SzczegolyUzytkownika(uzytkownik);
    }
}
