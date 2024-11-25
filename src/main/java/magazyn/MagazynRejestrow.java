package magazyn;

import modele.Rejestr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynRejestrow extends JpaRepository<Rejestr, Integer> {
}
