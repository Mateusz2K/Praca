package serwisy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import magazyn.MagazynHistoriKonta;
import magazyn.MagazynKonta;
import magazyn.MagazynTransakcji;
import modele.HistoriaKonta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class HistoriaKontaUsługa {
    private final MagazynHistoriKonta magazynHistoriKonta;
    private final MagazynKonta magazynKonta;
    private final MagazynTransakcji magazynTransakcji;
    @PersistenceContext
    private EntityManager entityManager;

    public HistoriaKontaUsługa(MagazynHistoriKonta magazynHistoriKonta, MagazynKonta magazynKonta, MagazynTransakcji magazynTransakcji) {
        this.magazynHistoriKonta = magazynHistoriKonta;
        this.magazynKonta = magazynKonta;
        this.magazynTransakcji = magazynTransakcji;
    }
    public HistoriaKonta stworzHistoriaKonta(LocalDateTime dataZmiany, BigDecimal kwotaZmiany, BigDecimal bilans, int idKonto, int idTransakcja){
        HistoriaKonta historiaKonta = new HistoriaKonta();
        historiaKonta.setDataZmiany(dataZmiany);
        historiaKonta.setKwotaZmiany(kwotaZmiany);
        historiaKonta.setBilans(bilans);
        historiaKonta.setKonto(magazynKonta.getReferenceById(idKonto));
        historiaKonta.setTransakcja(magazynTransakcji.getReferenceById(idTransakcja));
        return magazynHistoriKonta.save(historiaKonta);
    }
    public void usunHistorieKonta(int id){
        HistoriaKonta historiaKonta = magazynHistoriKonta.findById(id).orElseThrow(() -> new IllegalArgumentException("Urzytkownik o id: " + id + " nie istnieje"));
        magazynHistoriKonta.delete(historiaKonta);
    }
//    public HistoriaKonta znajdzHistorieDanegoKonta(int kontoId){
//        HistoriaKonta historiaKonta = magazynHistoriKont
//    }

}
