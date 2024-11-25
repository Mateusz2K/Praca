package magazyn;

import modele.TypPowiadomienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynTypowPowiadomien extends JpaRepository<TypPowiadomienia, Integer> {
}
