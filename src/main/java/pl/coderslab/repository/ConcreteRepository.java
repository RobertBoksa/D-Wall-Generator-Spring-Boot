package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Concrete;


@Repository
public interface ConcreteRepository extends JpaRepository<Concrete, Long> {
}
