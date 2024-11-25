package magazyn;

import modele.RaportOszczednosci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynRaportowOszczednosci extends JpaRepository<RaportOszczednosci, Integer> {
}
