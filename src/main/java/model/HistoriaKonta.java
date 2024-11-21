package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "historiaKonta")
public class HistoriaKonta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataZmiany;
    @Column(precision = 15, scale = 2 )
    private BigDecimal kwotaZmiany;
    @Column(precision = 15, scale = 2)
    private BigDecimal bilans;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "konto_id")
    private Konto konto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transakcja_id")
    private Transakcja transakcja;

    public HistoriaKonta(LocalDateTime dataZmiany, BigDecimal kwotaZmiany, BigDecimal bilans, Konto konto, Transakcja transakcja) {
        this.dataZmiany = dataZmiany;
        this.kwotaZmiany = kwotaZmiany;
        this.bilans = bilans;
        this.konto = konto;
        this.transakcja = transakcja;
    }

    public HistoriaKonta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataZmiany() {
        return dataZmiany;
    }

    public void setDataZmiany(LocalDateTime dataZmiany) {
        this.dataZmiany = dataZmiany;
    }

    public BigDecimal getKwotaZmiany() {
        return kwotaZmiany;
    }

    public void setKwotaZmiany(BigDecimal kwotaZmiany) {
        this.kwotaZmiany = kwotaZmiany;
    }

    public BigDecimal getBilans() {
        return bilans;
    }

    public void setBilans(BigDecimal bilans) {
        this.bilans = bilans;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public Transakcja getTransakcja() {
        return transakcja;
    }

    public void setTransakcja(Transakcja transakcja) {
        this.transakcja = transakcja;
    }
}
