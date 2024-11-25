package zarzadzanieFinansami.Kontrolery;

import magazyn.MagazynUzytkownika;
import modele.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Kontroler {


    @GetMapping("/hello")
    public String sayHello(){return "Hello from my first controller";}

    private final MagazynUzytkownika magazyn;

    public Kontroler(MagazynUzytkownika magazyn){
        this.magazyn = magazyn;
    }
    @PostMapping("/uzytkownik")
    public Uzytkownik post(@RequestBody Uzytkownik uzytkownik){
         return magazyn.save(uzytkownik);
    }
}

