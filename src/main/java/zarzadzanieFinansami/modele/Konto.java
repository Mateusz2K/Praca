package zarzadzanieFinansami.modele;

import jakarta.persistence.*;
import zarzadzanieFinansami.konwertery.TypKontaConverter;
import zarzadzanieFinansami.modele.enumeracje.TypKontaEnum;
import zarzadzanieFinansami.modele.enumeracje.WalutaEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



@Entity
@Table(name = "konto")
public class Konto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nazwa;
    @Column(precision = 15, scale = 2, nullable = false, columnDefinition = "DECIMAL(15,2) DEFAULT 0.00")
    private BigDecimal bilans;
    @Convert(converter = TypKontaConverter.class)
    @Column(nullable = false, name = "typ")
    @Enumerated(EnumType.STRING) // Przechowywanie wartości jako tekst w bazie
    private TypKontaEnum typ;
    @Column(nullable = false, name = "waluta")
    @Enumerated(EnumType.STRING) // Przechowywanie wartości jako tekst w bazie
    private WalutaEnum waluta;

    @Column(updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataUtworzenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    //cele
    @OneToMany(mappedBy = "konto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cel> cele;
    //@XzasadyOczcdzędzania
    @OneToMany(mappedBy = "odbiorca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ZasadyOszczedzania> zasadyOszczedzaniaOdbiorca;
    @OneToMany(mappedBy = "nadawca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ZasadyOszczedzania> zasadyOszczedzaniaNadawca;
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



    public Konto(String nazwa, BigDecimal bilans, TypKontaEnum typ, WalutaEnum waluta, LocalDateTime dataUtworzenia, Uzytkownik uzytkownik) {
        this.nazwa = nazwa;
        this.bilans = bilans;
        this.typ = typ;
        this.waluta = waluta;
        this.dataUtworzenia = dataUtworzenia;
        this.uzytkownik = uzytkownik;
    }

    public Konto() {
    }
    @PrePersist
    protected void onCreate() {
        this.dataUtworzenia = LocalDateTime.now();
        if(this.bilans == null) {
            this.bilans = BigDecimal.ZERO;
        }
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

    public BigDecimal getBilans() {
        return bilans;
    }

    public void setBilans(BigDecimal bilans) {
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

    public LocalDateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia() {
        if(dataUtworzenia == null) {
            this.dataUtworzenia = LocalDateTime.now();
        }

    }

    public List<Cel> getCele() {
        return cele;
    }

    public void setCele(List<Cel> cele) {
        this.cele = cele;
    }

    public List<ZasadyOszczedzania> getZasadyOszczedzaniaOdbiorca() {
        return zasadyOszczedzaniaOdbiorca;
    }

    public void setZasadyOszczedzaniaOdbiorca(List<ZasadyOszczedzania> zasadyOszczedzaniaOdbiorca) {
        this.zasadyOszczedzaniaOdbiorca = zasadyOszczedzaniaOdbiorca;
    }

    public List<ZasadyOszczedzania> getZasadyOszczedzaniaNadawca() {
        return zasadyOszczedzaniaNadawca;
    }

    public void setZasadyOszczedzaniaNadawca(List<ZasadyOszczedzania> zasadyOszczedzaniaNadawca) {
        this.zasadyOszczedzaniaNadawca = zasadyOszczedzaniaNadawca;
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
