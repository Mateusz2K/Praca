package model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Temporal;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transakcja")
public class Transakcja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String opis;
    @Column(precision = 15,scale = 2)
    private BigDecimal kwota;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypTransakcjiEnum typ;
    @Column(nullable = false)
    private Date data = new Date();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategoria", nullable = false) // poprawiona literówka
    private Kategoria kategoria;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "konto", nullable = false) // poprawiona literówka
    private Konto konto;

    public Transakcja(String opis, BigDecimal kwota, TypTransakcjiEnum typ, Date data, Kategoria kategoria, Konto konto) {
        this.opis = opis;
        this.kwota = kwota;
        this.typ = typ;
        this.data = data;
        this.kategoria = kategoria;
        this.konto = konto;
    }

    public Transakcja() {
    }

}
