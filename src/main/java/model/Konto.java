package model;

import jakarta.persistence.*;
import model.enums.TypKontaEnum;
import model.enums.WalutaEnum;

import java.util.Date;
import java.util.List;



@Entity
@Table(name = "konto")
public class Konto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "urzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    //cele
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cel> cele;
    //@XzasadyOczcdzędzania
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ZasadyOszczedzania> zasadyOszczedzania;
    //zasadyPowiadomien
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ZasadyPowiadomien> zasadyPowiadomien;
    //rejestr
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rejestr> rejestry;
    //transakcja
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transakcja> transakcje;
    //historia Konta
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriaKonta> historieKont;



    public Konto(String nazwa, double bilans, TypKontaEnum typ, WalutaEnum waluta, Date dataUtworzenia, Uzytkownik uzytkownik) {
        this.nazwa = nazwa;
        this.bilans = bilans;
        this.typ = typ;
        this.waluta = waluta;
        this.dataUtworzenia = dataUtworzenia;
        this.uzytkownik = uzytkownik;
    }

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

    public List<ZasadyOszczedzania> getZasadyOszczedzania() {
        return zasadyOszczedzania;
    }

    public void setZasadyOszczedzania(List<ZasadyOszczedzania> zasadyOszczedzania) {
        this.zasadyOszczedzania = zasadyOszczedzania;
    }

    public List<ZasadyPowiadomien> getZasadyPowiadomien() {
        return zasadyPowiadomien;
    }

    public void setZasadyPowiadomien(List<ZasadyPowiadomien> zasadyPowiadomien) {
        this.zasadyPowiadomien = zasadyPowiadomien;
    }

    public List<Rejestr> getRejestry() {
        return rejestry;
    }

    public void setRejestry(List<Rejestr> rejestry) {
        this.rejestry = rejestry;
    }

    public List<Transakcja> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(List<Transakcja> transakcje) {
        this.transakcje = transakcje;
    }

    public List<HistoriaKonta> getHistorieKont() {
        return historieKont;
    }

    public void setHistorieKont(List<HistoriaKonta> historieKont) {
        this.historieKont = historieKont;
    }
}
