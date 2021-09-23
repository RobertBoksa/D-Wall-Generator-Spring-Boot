package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Cage;

@Repository
public interface CageRepository extends JpaRepository<Cage, Long> {

}
