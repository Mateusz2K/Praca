package modele;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "powiadomienia")
public class Powiadomienia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String wiadomosc;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime wygenerowany_czas;
    private boolean czyPrzeczytane = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "urytkownik_id")
    private Uzytkownik uzytkownik;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typ_powiadomienia_id")
    private TypPowiadomienia typPowiadomienia;

    public Powiadomienia(String wiadomosc, LocalDateTime wygenerowany_czas, boolean czyPrzeczytane, Uzytkownik uzytkownik, TypPowiadomienia typPowiadomienia) {
        this.wiadomosc = wiadomosc;
        this.wygenerowany_czas = wygenerowany_czas;
        this.czyPrzeczytane = czyPrzeczytane;
        this.uzytkownik = uzytkownik;
        this.typPowiadomienia = typPowiadomienia;
    }

    public Powiadomienia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public LocalDateTime getWygenerowany_czas() {
        return wygenerowany_czas;
    }

    public void setWygenerowany_czas(LocalDateTime wygenerowany_czas) {
        this.wygenerowany_czas = wygenerowany_czas;
    }

    public boolean isCzyPrzeczytane() {
        return czyPrzeczytane;
    }

    public void setCzyPrzeczytane(boolean czyPrzeczytane) {
        this.czyPrzeczytane = czyPrzeczytane;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public TypPowiadomienia getTypPowiadomienia() {
        return typPowiadomienia;
    }

    public void setTypPowiadomienia(TypPowiadomienia typPowiadomienia) {
        this.typPowiadomienia = typPowiadomienia;
    }


}
