package model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Temporal;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "rejestr")
public class Rejestr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private Date dataOd;
    @Column(nullable = false)
    private Date dataDo;
    @Column(precision = 15, scale = 2)
    private BigDecimal limitBudzet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "konto_id", nullable = false)
    private Konto konto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategoria_id", nullable = false)
    private Kategoria kategoria;

    public Rejestr(Date dataOd, Date dataDo, BigDecimal limitBudzet, Konto konto, Kategoria kategoria) {
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.limitBudzet = limitBudzet;
        this.konto = konto;
        this.kategoria = kategoria;
    }

    public Rejestr() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    public BigDecimal getLimitBudzet() {
        return limitBudzet;
    }

    public void setLimitBudzet(BigDecimal limitBudzet) {
        this.limitBudzet = limitBudzet;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
}
