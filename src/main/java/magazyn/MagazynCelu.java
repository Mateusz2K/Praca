package magazyn;

import modele.Cel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynCelu extends JpaRepository<Cel, Integer> {
}
