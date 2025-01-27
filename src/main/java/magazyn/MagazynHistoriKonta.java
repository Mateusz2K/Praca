package magazyn;

import modele.HistoriaKonta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazynHistoriKonta extends JpaRepository<HistoriaKonta, Integer> {
}
