package model;

import jakarta.persistence.*;

@Entity
@Table(name = "typPowiadomienia")
public class TypPowiadomienia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 100)
    private String nazwa;
    @Column(length = 100)
    private String opis;

    public TypPowiadomienia(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public TypPowiadomienia() {
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
