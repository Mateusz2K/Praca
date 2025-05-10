package zarzadzanieFinansami.serwisy;

import zarzadzanieFinansami.magazyn.MagazynKategorii;
import zarzadzanieFinansami.modele.Kategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategoriaUsługa {
    @Autowired
    private final MagazynKategorii magazynKategorii;

    public KategoriaUsługa(MagazynKategorii magazynKategorii) {
        this.magazynKategorii = magazynKategorii;
    }
    public List<Kategoria> getKategorie() {
        return magazynKategorii.findAll();
    }
    public Optional<Kategoria> getKategoria(int idKategori) {
        return magazynKategorii.findById(idKategori);
    }
    public Optional<Kategoria> getKategoria(String kategoria) {
        return magazynKategorii.findByNazwa(kategoria);
    }
    public Optional<Kategoria> getKategoriaPrzezTypTransakcji(String typTransakcje) {
        if (typTransakcje == null) {
            return Optional.empty();
        }
        return magazynKategorii.findByTypTransakcji(typTransakcje);
    }
    public void deleteKategoria(Kategoria kategoria) {
        magazynKategorii.delete(kategoria);
    }
    public void deleteKategoria(int idKategori) {
        magazynKategorii.deleteById(idKategori);
    }

    public Kategoria updateKategoria(Kategoria kategoria,  Kategoria newKategoria) {
        Optional<Kategoria> kategorieZMagazynu = magazynKategorii.findById(kategoria.getId());
        if (kategorieZMagazynu.isPresent()) {
            Kategoria kategoriaZMagazynu = kategorieZMagazynu.get();
            kategoriaZMagazynu.setNazwa(newKategoria.getNazwa());
            kategoriaZMagazynu.setTypTransakcji(newKategoria.getTypTransakcji());
            magazynKategorii.saveAndFlush(kategoriaZMagazynu);
            return kategoriaZMagazynu;
        }
        return null;

    }
}
