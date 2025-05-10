package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.TypPowiadomienia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MagazynTypowPowiadomien extends JpaRepository<TypPowiadomienia, Integer> {
    @Override
    <S extends TypPowiadomienia> S save(S entity);

    @Override
    void delete(TypPowiadomienia entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<TypPowiadomienia> findById(Integer integer);

    @Override
    List<TypPowiadomienia> findAll();
}
