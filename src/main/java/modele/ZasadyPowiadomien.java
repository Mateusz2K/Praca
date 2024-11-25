package modele;

import jakarta.persistence.*;
import modele.enumeracje.RegulaEnum;

@Entity
@Table(name = "zasadyPowiadomien")
public class ZasadyPowiadomien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private RegulaEnum regula;
    private double wartpscLimit;
    private boolean czyAktywna;

    @JoinColumn(name = "uzytkownik_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Uzytkownik uzytkownik;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "konto_id", nullable = false)
    private Konto konto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cel_id")
    private Cel cel;

    public ZasadyPowiadomien(RegulaEnum regula, double wartpscLimit, boolean czyAktywna, Uzytkownik uzytkownik, Konto konto, Cel cel) {
        this.regula = regula;
        this.wartpscLimit = wartpscLimit;
        this.czyAktywna = czyAktywna;
        this.uzytkownik = uzytkownik;
        this.konto = konto;
        this.cel = cel;
    }

    public ZasadyPowiadomien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RegulaEnum getRegula() {
        return regula;
    }

    public void setRegula(RegulaEnum regula) {
        this.regula = regula;
    }

    public double getWartpscLimit() {
        return wartpscLimit;
    }

    public void setWartpscLimit(double wartpscLimit) {
        this.wartpscLimit = wartpscLimit;
    }

    public boolean isCzyAktywna() {
        return czyAktywna;
    }

    public void setCzyAktywna(boolean czyAktywna) {
        this.czyAktywna = czyAktywna;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public Cel getCel() {
        return cel;
    }

    public void setCel(Cel cel) {
        this.cel = cel;
    }
}
