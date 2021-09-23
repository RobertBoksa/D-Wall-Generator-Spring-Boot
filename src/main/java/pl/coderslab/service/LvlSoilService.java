package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.LvlSoil;
import pl.coderslab.repository.LvlSoilRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LvlSoilService implements ServiceForAll<LvlSoil, Long> {

    private final LvlSoilRepository lvlSoilRepository;

    public LvlSoilService(LvlSoilRepository lvlSoilRepository) {
        this.lvlSoilRepository = lvlSoilRepository;
    }

    @Override
    public List<LvlSoil> getAll() {
        return lvlSoilRepository.findAll();
    }

    @Override
    public void add(LvlSoil lvlSoil) {
        lvlSoilRepository.save(lvlSoil);
    }

    @Override
    public Optional<LvlSoil> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(LvlSoil lvlSoil) {

    }


    public List<LvlSoil> allLvlSoilByIdDigging(Long idDigging){
        return lvlSoilRepository.findAllByDiggingId(idDigging);
    }
}
