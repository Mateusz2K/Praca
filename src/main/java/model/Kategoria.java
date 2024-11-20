package model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "kategoria")
public class Kategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nazwa;
    @Enumerated(EnumType.STRING)
    private TypTransakcjiEnum typTransakcji;

    public Kategoria(String nazwa, TypTransakcjiEnum typTransakcji) {
        this.nazwa = nazwa;
        this.typTransakcji = typTransakcji;
    }
}
