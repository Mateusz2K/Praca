package magazyn;

import modele.ZasadyOszczedzania;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazynZasadOszczedzania extends JpaRepository<ZasadyOszczedzania, Integer> {
}
