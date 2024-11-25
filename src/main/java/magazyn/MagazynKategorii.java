package magazyn;

import modele.Kategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazynKategorii extends JpaRepository<Kategoria, Integer> {
}
