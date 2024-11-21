package model;

import jakarta.persistence.*;
import model.enums.TypTransakcjiEnum;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "kategoria")
public class Kategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nazwa;
    @Enumerated(EnumType.STRING)
    private TypTransakcjiEnum typTransakcji;

    public Kategoria() {
    }

    public Kategoria(String nazwa, TypTransakcjiEnum typTransakcji) {
        this.nazwa = nazwa;
        this.typTransakcji = typTransakcji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public TypTransakcjiEnum getTypTransakcji() {
        return typTransakcji;
    }

    public void setTypTransakcji(TypTransakcjiEnum typTransakcji) {
        this.typTransakcji = typTransakcji;
    }
}
