package zarzadzanieFinansami.serwisy;

import jakarta.validation.constraints.NotNull;
import org.springframework.transaction.annotation.Transactional;
import zarzadzanieFinansami.DTO.KontoResponseDTO;
import zarzadzanieFinansami.DTO.KontoTworzenieDTO;
import zarzadzanieFinansami.magazyn.MagazynKonta;
import zarzadzanieFinansami.modele.Cel;
import zarzadzanieFinansami.modele.Konto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zarzadzanieFinansami.modele.Uzytkownik;
import zarzadzanieFinansami.modele.enumeracje.TypKontaEnum;
import zarzadzanieFinansami.modele.enumeracje.WalutaEnum;

import java.math.BigDecimal;
import java.util.*;

@Service
public class KontoUsługa {

    @Autowired
    private final MagazynKonta magazynKonta;

    public KontoUsługa(MagazynKonta magazynKonta) {
        this.magazynKonta = magazynKonta;
    }

    public List<Konto> znajdzWszystkieKonta(){
        return magazynKonta.findAll();
    }
    public Optional<Konto> znajdzKontoPrzezId(int id) {
        return magazynKonta.findById(id);
    }
    //DTO
    @Transactional
    public Konto stworzenieKontoDlaUzytkownika(KontoTworzenieDTO kontoDTO, Uzytkownik uzytkownik) {
        if(kontoDTO == null || uzytkownik == null){
            throw new IllegalArgumentException("Dane do utworzenia lub uzytkownik nie mogą byc puste.");
        }
        Konto noweKonto = new Konto();
        noweKonto.setNazwa(kontoDTO.getNazwa());
        try{
            noweKonto.setTyp(TypKontaEnum.valueOf(kontoDTO.getTyp().toUpperCase()));
            noweKonto.setWaluta(WalutaEnum.valueOf(kontoDTO.getWaluta().toUpperCase()));
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Nie prawidłowy typ konta lub waluta.");
        }
        noweKonto.setBilans(kontoDTO.getBilansPoczatkowy() != null ? kontoDTO.getBilansPoczatkowy() : BigDecimal.ZERO);
        noweKonto.setUzytkownik(uzytkownik);
        return magazynKonta.save(noweKonto);
    }
    public List<Konto> znajdzKontoPrzezNazwa(String nazwa) {
        return magazynKonta.findByNazwa(nazwa);
    }
    public void usunKonto(Konto konto) {
        magazynKonta.delete(konto);
    }
    public Konto updateKonto(@NotNull Konto konto, Konto newKonto) {
        Optional<Konto> kontoZMagazynu = magazynKonta.findById(konto.getId());
        if (kontoZMagazynu.isPresent()) {
            Konto kontoZMagazynu1 = kontoZMagazynu.get();
            if (newKonto.getNazwa() != null) {
                kontoZMagazynu1.setNazwa(newKonto.getNazwa());
            }
            if (newKonto.getBilans() != null){
                kontoZMagazynu1.setBilans(newKonto.getBilans());
            }
            if (newKonto.getWaluta() != null){
                kontoZMagazynu1.setWaluta(newKonto.getWaluta());
            }
            if (!newKonto.getCele().isEmpty()){
                Set<Cel> setOfCele = new HashSet<>(newKonto.getCele());
                setOfCele.addAll(kontoZMagazynu1.getCele());
                List<Cel>  cele = new ArrayList<>(setOfCele);
                kontoZMagazynu1.setCele(cele);
            }

            return kontoZMagazynu1;
        }
        return konto;
    }

    @Transactional(readOnly = true)
    public List<Konto> znajdzKontaDlaUzytkownika(Uzytkownik nazwaUzytkownika) {
        if (nazwaUzytkownika == null) {
            return Collections.emptyList();
        }
        return magazynKonta.findByUzytkownik(nazwaUzytkownika);
    }
}
