package model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;



@Entity
@Table(name = "konto")
public class Konto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uzytkownik_id", nullable = false) // poprawiona literówka
    private Uzytkownik uzytkownik; // poprawiona nazwa klasy i pola

    private String nazwa;
    @Column(precision = 15, scale = 2)
    private double bilans;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Przechowywanie wartości jako tekst w bazie
    private TypKontaEnum typ;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Przechowywanie wartości jako tekst w bazie
    private WalutaEnum waluta;

    @Column(nullable = false, updatable = false) // Pole nieedytowalne po utworzeniu
    @Temporal(TemporalType.TIMESTAMP) // Dla zgodności z typem TIMESTAMP w bazie
    private Date dataUtworzenia = new Date(); // Ustawienie domyślnej wartości

    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cel> cele;


    // Gettery i Settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getBilans() {
        return bilans;
    }

    public void setBilans(double bilans) {
        this.bilans = bilans;
    }

    public TypKontaEnum getTyp() {
        return typ;
    }

    public void setTyp(TypKontaEnum typ) {
        this.typ = typ;
    }

    public WalutaEnum getWaluta() {
        return waluta;
    }

    public void setWaluta(WalutaEnum waluta) {
        this.waluta = waluta;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public List<Cel> getCele() {
        return cele;
    }

    public void setCele(List<Cel> cele) {
        this.cele = cele;
    }
}
