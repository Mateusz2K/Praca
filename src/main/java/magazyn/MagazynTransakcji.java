package magazyn;

import modele.Transakcja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynTransakcji extends JpaRepository<Transakcja, Integer> {
}
