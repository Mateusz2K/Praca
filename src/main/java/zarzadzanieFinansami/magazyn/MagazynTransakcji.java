package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.Transakcja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MagazynTransakcji extends JpaRepository<Transakcja, Integer> {
    @Override
    <S extends Transakcja> S saveAndFlush(S entity);

    @Override
    void delete(Transakcja entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<Transakcja> findById(Integer integer);

    @Override
    List<Transakcja> findAll();
}
