package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Section;

import java.util.List;


@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    List<Section> findSectionsByStatus(int status1);
}
