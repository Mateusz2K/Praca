package zarzadzanieFinansami.Kontrolery;

import zarzadzanieFinansami.modele.Cel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zarzadzanieFinansami.serwisy.CelUsługa;
@RequestMapping("/api")
@RestController
public class CelKontroler {

    @Autowired
    private final CelUsługa celUsługa;

    @Autowired
    public CelKontroler(CelUsługa celUsługa) {
        this.celUsługa = celUsługa;
    }

    @GetMapping("/cel/{id}")
    public Cel getCelPrzeId(@PathVariable("id") int id){
        return celUsługa.znajdzCel(id);
    }
    @DeleteMapping("/cel/{id}")
    public void deleteCel(@PathVariable("id") int id){
        celUsługa.usunCel(id);
    }
    @PostMapping("/cel")
    public void addCel(Cel cel){
        celUsługa.dodajCel(cel);
    }
    @GetMapping("/cel/")
    public void getCele(){
        celUsługa.znajdzCele();
    }
}
