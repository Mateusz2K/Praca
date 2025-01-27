package magazyn;

import modele.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MagazynUzytkownika extends JpaRepository<Uzytkownik, Integer> {
    Optional<Uzytkownik> findByEmail(String email);

}