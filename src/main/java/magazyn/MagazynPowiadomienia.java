package magazyn;

import modele.Powiadomienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynPowiadomienia extends JpaRepository<Powiadomienia, Integer> {
}
