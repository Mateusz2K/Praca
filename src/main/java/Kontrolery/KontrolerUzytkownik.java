package Kontrolery;

import DTO.UzytkownikDTO;
import modele.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serwisy.UzytkownikUsługa;

@RestController
public class KontrolerUzytkownik {

    private final UzytkownikUsługa uzytkownikUsługa;

    @Autowired
    public KontrolerUzytkownik(UzytkownikUsługa uzytkownikUsługa){
        this.uzytkownikUsługa = uzytkownikUsługa;
    }

    @GetMapping("/uzytkownik/{id}")
    public Uzytkownik getUzytkownikPrzezId(@PathVariable("id")int id){
        return uzytkownikUsługa.znajdzUrzytkownikaPrzezId(id);
    }


    @PostMapping("/uzytkownik")
    public ResponseEntity<?> post(@RequestBody UzytkownikDTO uzytkownikDTO){
         var uzytkownik = uzytkownikUsługa.stworzUzytkownika(uzytkownikDTO);
         return ResponseEntity.ok(uzytkownik);
    }
}

