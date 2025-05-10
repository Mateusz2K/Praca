package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.ZasadyPowiadomien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MagazynZasadPowiadomien extends JpaRepository<ZasadyPowiadomien, Integer> {
    @Override
    <S extends ZasadyPowiadomien> S saveAndFlush(S entity);

    @Override
    void delete(ZasadyPowiadomien entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<ZasadyPowiadomien> findById(Integer integer);

    @Override
    List<ZasadyPowiadomien> findAll();
}
