package serwisy;

import magazyn.MagazynCelu;
import magazyn.MagazynKonta;
import magazyn.MagazynUzytkownika;
import magazyn.MagazynZasadPowiadomien;
import modele.ZasadyPowiadomien;
import modele.enumeracje.RegulaEnum;
import org.springframework.stereotype.Service;

@Service
public class ZasadyPowiadomienUsługa {
    private final MagazynZasadPowiadomien magazynZasadPowiadomien;
    private final MagazynUzytkownika magazynUzytkownika;
    private final MagazynCelu magazynCelu;
    private final MagazynKonta magazynKonta;

    public ZasadyPowiadomienUsługa(MagazynZasadPowiadomien magazynZasadPowiadomien, MagazynUzytkownika magazynUzytkownika, MagazynCelu magazynCelu, MagazynKonta magazynKonta){
        this.magazynZasadPowiadomien = magazynZasadPowiadomien;
        this.magazynUzytkownika = magazynUzytkownika;
        this.magazynCelu = magazynCelu;
        this.magazynKonta = magazynKonta;
    }

    public ZasadyPowiadomien stworzZasadyPowiadomien(String regula, double wartoscLimit, boolean czyAktywna, int idUzytkownika, int idKonto, int idCel){
        ZasadyPowiadomien zasadyPowiadomien = new ZasadyPowiadomien();
        zasadyPowiadomien.setCel(magazynCelu.getReferenceById(idCel));
        zasadyPowiadomien.setUzytkownik(magazynUzytkownika.getReferenceById(idUzytkownika));
        zasadyPowiadomien.setKonto(magazynKonta.getReferenceById(idKonto));
        zasadyPowiadomien.setRegula(RegulaEnum.valueOf(regula));
        zasadyPowiadomien.setCzyAktywna(czyAktywna);
        zasadyPowiadomien.setWartoscLimit(wartoscLimit);
        return magazynZasadPowiadomien.save(zasadyPowiadomien);
    }
}
