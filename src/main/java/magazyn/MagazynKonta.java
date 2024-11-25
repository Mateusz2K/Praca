package magazyn;

import modele.Konto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynKonta extends JpaRepository<Konto, Integer> {
}
