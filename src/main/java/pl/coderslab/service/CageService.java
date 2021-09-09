package pl.coderslab.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Cage;
import pl.coderslab.repository.CageRepository;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Optional;


@Service
public class CageService implements ServiceForAll<Cage, Long> {

    private final CageRepository cageRepository;

    public CageService(CageRepository cageRepository) {
        this.cageRepository = cageRepository;
    }

    @Override
    public List<Cage> getAll() {
        return cageRepository.findAll();
    }

    @Override
    public void add(Cage cage) {
        cageRepository.save(cage);
    }

    @Override
    public Optional<Cage> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }
}
