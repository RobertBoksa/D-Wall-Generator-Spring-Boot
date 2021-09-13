package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.LvlSoil;

import java.util.List;


@Repository
public interface LvlSoilRepository extends JpaRepository<LvlSoil, Long> {

    List<LvlSoil> findAllByDiggingId(Long idDigging);
}
