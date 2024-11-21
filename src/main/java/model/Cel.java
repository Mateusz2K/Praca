package model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Date;

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
    private BigDecimal zebranaKwota;

    @Temporal(TemporalType.TIMESTAMP)
    private Date termin;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "konto_id", nullable = false)
    private Konto konto;

    // Konstruktor domyślny
    public Cel() {
    }

    // Konstruktor z parametrami
    public Cel(int id, String nazwa, BigDecimal okreslonaKwota, BigDecimal zebranaKwota, Date termin, Konto konto) {
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

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
}