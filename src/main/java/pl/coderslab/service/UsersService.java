package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Users;
import pl.coderslab.repository.UsersRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UsersService implements ServiceForAll<Users, Long>{

    private final UsersRepository personRepository;

    public UsersService(UsersRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void add(Users user) {

    }

    @Override
    public Optional<Users> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Users user) {
    }
}
