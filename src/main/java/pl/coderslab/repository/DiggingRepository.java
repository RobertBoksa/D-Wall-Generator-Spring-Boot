package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Digging;

@Repository
public interface DiggingRepository extends JpaRepository<Digging, Long> {


}
