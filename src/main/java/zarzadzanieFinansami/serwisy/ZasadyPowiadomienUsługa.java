package zarzadzanieFinansami.serwisy;

import zarzadzanieFinansami.magazyn.MagazynCelu;
import zarzadzanieFinansami.magazyn.MagazynKonta;
import zarzadzanieFinansami.magazyn.MagazynUzytkownika;
import zarzadzanieFinansami.magazyn.MagazynZasadPowiadomien;
import zarzadzanieFinansami.modele.ZasadyPowiadomien;
import zarzadzanieFinansami.modele.enumeracje.RegulaEnum;
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
