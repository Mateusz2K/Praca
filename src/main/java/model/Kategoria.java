package model;

import jakarta.persistence.*;
import model.enums.TypTransakcjiEnum;
import org.springframework.data.annotation.Id;

import java.util.List;

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

    //połaczenie transakcji
    @OneToMany(mappedBy = "kategoria", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = false)
    private List<Transakcja> transakcje;
    //połaczzenie rejestrów
    @OneToMany(mappedBy = "kategoria", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = false)
    private List<Rejestr> rejestry;

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

    public List<Transakcja> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(List<Transakcja> transakcje) {
        this.transakcje = transakcje;
    }

    public List<Rejestr> getRejestry() {
        return rejestry;
    }

    public void setRejestry(List<Rejestr> rejestry) {
        this.rejestry = rejestry;
    }
}
