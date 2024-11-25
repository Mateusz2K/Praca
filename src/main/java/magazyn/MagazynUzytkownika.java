package magazyn;

import modele.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MagazynUzytkownika extends JpaRepository<Uzytkownik, Integer> {
}
