package magazyn;

import modele.ZasadyPowiadomien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazynZasadPowiadomien extends JpaRepository<ZasadyPowiadomien, Integer> {
}
