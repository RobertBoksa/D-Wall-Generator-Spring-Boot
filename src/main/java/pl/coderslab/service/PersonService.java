package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Person;
import pl.coderslab.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService implements ServiceForAll<Person, Long>{

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public void add(Person person) {

    }

    @Override
    public Optional<Person> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }
}
