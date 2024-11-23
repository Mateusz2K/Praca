package model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cel")
public class Cel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nazwa;
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal okreslonaKwota;
    @Column(precision = 15, scale = 2)
    private BigDecimal zebranaKwota = BigDecimal.ZERO;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime termin;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "konto_id", nullable = false)
    private Konto konto;

    //połączenie raportów oszczedności
    @OneToMany(mappedBy = "cel", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = false)
    private List<RaportOszczednosci> raportyOszczednosci;
    //połaczenie zasad Oszcedzania bez usuwanych rekordów
    @OneToMany(mappedBy = "cel", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = false)
    private List<ZasadyOszczedzania> zasadyOszczedzania;
    //połaczenie zasad Powiadomien
    @OneToMany(mappedBy = "cel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ZasadyPowiadomien> zasadyPowiadomien;

    // Konstruktor domyślny
    public Cel() {
    }

    // Konstruktor z parametrami
    public Cel(int id, String nazwa, BigDecimal okreslonaKwota, BigDecimal zebranaKwota, LocalDateTime termin, Konto konto) {
        this.id = id;
        this.nazwa = nazwa;
        this.okreslonaKwota = okreslonaKwota;
        this.zebranaKwota = zebranaKwota;
        this.termin = termin;
        this.konto = konto;
    }

    // Gettery i Settery
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