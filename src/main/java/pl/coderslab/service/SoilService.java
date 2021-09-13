package pl.coderslab.service;


import org.springframework.stereotype.Service;
import pl.coderslab.model.Soil;
import pl.coderslab.repository.SoilRepository;

import java.util.List;
import java.util.Optional;


@Service
public class SoilService implements ServiceForAll<Soil, Long> {

    private final SoilRepository soilRepository;

    public SoilService(SoilRepository soilRepository) {
        this.soilRepository = soilRepository;
    }

    @Override
    public List<Soil> getAll() {
        return soilRepository.findAll();
    }


    @Override
    public void add(Soil soil) {
        soilRepository.save(soil);
    }

    @Override
    public Optional<Soil> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Soil soil) {

    }
}
