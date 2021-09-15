package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Concrete;
import pl.coderslab.repository.ConcreteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConcreteService implements ServiceForAll<Concrete,Long> {

    private final ConcreteRepository concreteRepository;

    public ConcreteService(ConcreteRepository concreteRepository) {
        this.concreteRepository = concreteRepository;
    }

    @Override
    public List<Concrete> getAll() {
        return concreteRepository.findAll();
    }

    @Override
    public void add(Concrete concrete) {
        concrete.setControlTime(LocalDateTime.now());
        concreteRepository.save(concrete);
    }

    @Override
    public Optional<Concrete> get(Long id) {
        return concreteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        concreteRepository.deleteById(id);
    }

    @Override
    public void update(Concrete concrete) {

    }
}
