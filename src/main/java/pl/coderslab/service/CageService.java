package pl.coderslab.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Cage;
import pl.coderslab.repository.CageRepository;

import javax.lang.model.element.Name;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CageService implements ServiceForAll<Cage, Long> {

    private final CageRepository cageRepository;

    public CageService(CageRepository cageRepository) {
        this.cageRepository = cageRepository;
    }

    @Transactional
    @Override
    public List<Cage> getAll() {
        List<Cage> cages = cageRepository.findAll();
        cages.forEach(c -> c.getSectionList().size());
        return cages;
    }

    @Override
    public void add(Cage cage) {
        cage = calcBottomOfCage(cage);
        cageRepository.save(cage);
    }

    @Override
    public Optional<Cage> get(Long id) {
        return cageRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Cage cage = cageRepository.getById(id);
        cageRepository.delete(cage);
    }

    @Override
    public void update(Cage cage) {
        cage = calcBottomOfCage(cage);
        cageRepository.save(cage);
    }



    private Cage calcBottomOfCage(Cage cage){
        cage.setCageBotLvl(1.00 * cage.getCageTopLvl()- cage.getCageHeight());
        return cage;
    }
}

