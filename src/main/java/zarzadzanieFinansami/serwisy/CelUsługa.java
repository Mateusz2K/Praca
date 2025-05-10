package zarzadzanieFinansami.serwisy;

import zarzadzanieFinansami.magazyn.MagazynCelu;
import zarzadzanieFinansami.magazyn.MagazynKonta;
import zarzadzanieFinansami.modele.Cel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CelUsługa {
    private final MagazynKonta magazynKonta;
    private final MagazynCelu magazynCelu;

    @Autowired
    public CelUsługa(MagazynKonta magazynKonta, MagazynCelu magazynCelu) {
        this.magazynKonta = magazynKonta;
        this.magazynCelu = magazynCelu;
    }
    public void dodajCel (Cel cel){
        magazynCelu.save(new Cel(cel.getNazwa(), cel.getOkreslonaKwota(),cel.getZebranaKwota(),cel.getTermin(), magazynKonta.getReferenceById(cel.getKonto().getId())));//TODO: dodać parametry brakujące
    }
    public void usunCel(int id){
        Cel cel = magazynCelu.findById(id).orElseThrow(() -> new IllegalArgumentException("Cel o id: " + id + " nie istnieje"));
        magazynCelu.delete(cel);
    }
    public Cel znajdzCel(int id){
        return magazynCelu.findById(id).orElseThrow(() -> new IllegalArgumentException("Cel o id: " + id + " nie istnieje"));
    }
    public List<Cel> znajdzCele(){
        return magazynCelu.findAll();
    }

}
