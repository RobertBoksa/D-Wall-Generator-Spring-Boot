package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Soil;

@Repository
public interface SoilRepository extends JpaRepository<Soil, Long> {
}
