package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

}
