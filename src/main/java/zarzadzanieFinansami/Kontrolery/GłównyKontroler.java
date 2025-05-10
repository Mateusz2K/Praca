package zarzadzanieFinansami.Kontrolery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
@RequestMapping("/api")
@RestController
public class GłównyKontroler {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hello World");
        return "Hello World";
    }
}
