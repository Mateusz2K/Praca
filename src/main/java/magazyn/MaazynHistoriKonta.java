package magazyn;

import modele.HistoriaKonta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaazynHistoriKonta extends JpaRepository<HistoriaKonta, Integer> {
}
