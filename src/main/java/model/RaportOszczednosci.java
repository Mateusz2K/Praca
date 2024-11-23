package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "raportOszczednosci")
public class RaportOszczednosci {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime terminRaportu;
    @Column(precision = 15, scale = 2)
    private BigDecimal zaosczedzonaKwota;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "urzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cel_id" , nullable = false)
    private Cel cel;

    public RaportOszczednosci(LocalDateTime terminRaportu, BigDecimal zaosczedzonaKwota, Uzytkownik uzytkownik, Cel cel) {
        this.terminRaportu = terminRaportu;
        this.zaosczedzonaKwota = zaosczedzonaKwota;
        this.uzytkownik = uzytkownik;
        this.cel = cel;
    }

    public RaportOszczednosci() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTerminRaportu() {
        return terminRaportu;
    }

    public void setTerminRaportu(LocalDateTime terminRaportu) {
        this.terminRaportu = terminRaportu;
    }

    public BigDecimal getZaosczedzonaKwota() {
        return zaosczedzonaKwota;
    }

    public void setZaosczedzonaKwota(BigDecimal zaosczedzonaKwota) {
        this.zaosczedzonaKwota = zaosczedzonaKwota;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Cel getCel() {
        return cel;
    }

    public void setCel(Cel cel) {
        this.cel = cel;
    }
}
