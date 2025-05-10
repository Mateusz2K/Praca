package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.Powiadomienia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MagazynPowiadomienia extends JpaRepository<Powiadomienia, Integer> {
    @Override
    <S extends Powiadomienia> S saveAndFlush(S entity);

    @Override
    void delete(Powiadomienia entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<Powiadomienia> findById(Integer integer);

    @Override
    List<Powiadomienia> findAll();
}
