package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Digging;
import pl.coderslab.repository.DiggingRepository;
import pl.coderslab.repository.SoilRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiggingService implements ServiceForAll<Digging, Long> {

    private final DiggingRepository diggingRepository;
    private final SoilRepository soilRepository;


    public DiggingService(DiggingRepository diggingRepository, SoilRepository soilRepository) {
        this.diggingRepository = diggingRepository;
        this.soilRepository = soilRepository;
    }

    @Override
    public List<Digging> getAll() {
        return null;
    }

    @Override
    public void add(Digging digging) {

    }

    @Override
    public Optional<Digging> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Digging digging) {

    }
}
