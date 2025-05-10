package zarzadzanieFinansami.modele;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cel")
public class Cel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nazwa",nullable = false)
    private String nazwa;
    @Column(name = "okreslonaKwota",nullable = false, precision = 15, scale = 2)
    private BigDecimal okreslonaKwota;
    @Column( name = "zebranaKwota",precision = 15, scale = 2)
    private BigDecimal zebranaKwota = BigDecimal.ZERO;
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime termin;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "konto_id", nullable = false)
    private Konto konto;

    //połączenie raportów oszczedności
    @OneToMany(mappedBy = "cel", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = false)
    private List<RaportOszczednosci> raportyOszczednosci = new ArrayList<>();
    //połaczenie zasad Oszcedzania bez usuwanych rekordów
    @OneToMany(mappedBy = "cel", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = false)
    private List<ZasadyOszczedzania> zasadyOszczedzania = new ArrayList<>();
    //połaczenie zasad Powiadomien
    @OneToMany(mappedBy = "cel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ZasadyPowiadomien> zasadyPowiadomien = new ArrayList<>();

    // Konstruktor domyślny
    public Cel() {
    }

    // Konstruktor z parametrami
    public Cel(Integer id, String nazwa, BigDecimal okreslonaKwota, BigDecimal zebranaKwota, LocalDateTime termin, Konto konto) {
        this.id = id;
        this.nazwa = nazwa;
        this.okreslonaKwota = okreslonaKwota;
        this.zebranaKwota = zebranaKwota;
        this.termin = termin;
        this.konto = konto;
    }

    public Cel(String nazwa, BigDecimal okreslonaKwota, BigDecimal zebranaKwota, LocalDateTime termin, Konto konto, List<RaportOszczednosci> raportyOszczednosci, List<ZasadyOszczedzania> zasadyOszczedzania, List<ZasadyPowiadomien> zasadyPowiadomien) {
        this.nazwa = nazwa;
        this.okreslonaKwota = okreslonaKwota;
        this.zebranaKwota = zebranaKwota;
        this.termin = termin;
        this.konto = konto;
        this.raportyOszczednosci = raportyOszczednosci;
        this.zasadyOszczedzania = zasadyOszczedzania;
        this.zasadyPowiadomien = zasadyPowiadomien;
    }

    public Cel(String nazwa, BigDecimal okreslonaKwota, BigDecimal zebranaKwota, LocalDateTime termin, Konto konto) {
        this.nazwa = nazwa;
        this.okreslonaKwota = okreslonaKwota;
        this.zebranaKwota = zebranaKwota;
        this.termin = termin;
        this.konto = konto;
    }

    // Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getOkreslonaKwota() {
        return okreslonaKwota;
    }

    public void setOkreslonaKwota(BigDecimal okreslonaKwota) {
        this.okreslonaKwota = okreslonaKwota;
    }

    public BigDecimal getZebranaKwota() {
        return zebranaKwota;
    }

    public void setZebranaKwota(BigDecimal zebranaKwota) {
        this.zebranaKwota = zebranaKwota;
    }

    public LocalDateTime getTermin() {
        return termin;
    }

    public void setTermin(LocalDateTime termin) {
        this.termin = termin;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public List<RaportOszczednosci> getRaportyOszczednosci() {
        return raportyOszczednosci;
    }

    public void setRaportyOszczednosci(List<RaportOszczednosci> raportyOszczednosci) {
        this.raportyOszczednosci = raportyOszczednosci;
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
}