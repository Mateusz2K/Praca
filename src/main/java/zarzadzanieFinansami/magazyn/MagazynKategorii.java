package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.Kategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MagazynKategorii extends JpaRepository<Kategoria, Integer> {
    @Override
    <S extends Kategoria> S saveAndFlush(S entity);

    @Override
    void delete(Kategoria entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<Kategoria> findById(Integer integer);

    @Override
    List<Kategoria> findAll();

    Optional<Kategoria> findByNazwa(String nazwa);
    Optional<Kategoria> findByTypTransakcji(String typTransakcji);
}
