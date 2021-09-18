package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Concrete;


@Repository
public interface ConcreteRepository extends JpaRepository<Concrete, Long> {

    @Query("select sum (c.concreteValue) from Concrete c where c.sectionCon.id = ?1")
    Long countConcrete(Long id);
}
