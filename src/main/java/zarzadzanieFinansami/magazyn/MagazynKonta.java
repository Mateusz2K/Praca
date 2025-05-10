package zarzadzanieFinansami.magazyn;

import zarzadzanieFinansami.modele.Konto;
import org.springframework.data.jpa.repository.JpaRepository;
import zarzadzanieFinansami.modele.Uzytkownik;

import java.util.List;
import java.util.Optional;

public interface MagazynKonta extends JpaRepository<Konto, Integer> {
    @Override
    <S extends Konto> S saveAndFlush(S entity);

    @Override
    void delete(Konto entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<Konto> findById(Integer integer);

    @Override
    List<Konto> findAll();
    List<Konto> findByNazwa(String nazwa);

    List<Konto> findByUzytkownik(Uzytkownik nazwaUzytkownika);
//    Optional<Konto> findByUzytkownik(Uzytkownik uzytkownik);
//    Optional<Konto> findKontoByCele(List<Cel> cele);
//    Optional<Konto> findKontoByZasadyOszczedzaniaNadawcaIsLike();

}
