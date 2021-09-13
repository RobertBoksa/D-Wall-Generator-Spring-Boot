package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Digging;
import pl.coderslab.repository.DiggingRepository;
import pl.coderslab.repository.SoilRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DiggingService implements ServiceForAll<Digging, Long> {

    private final DiggingRepository diggingRepository;



    public DiggingService(DiggingRepository diggingRepository) {
        this.diggingRepository = diggingRepository;

    }

    @Transactional
    @Override
    public List<Digging> getAll() {
        List<Digging> diggingList =diggingRepository.findAll();
        diggingList.forEach(d -> d.getLvlSoilList().size());
        return  diggingList;
    }

    @Override
    public void add(Digging digging) {
        LocalDateTime startTime = LocalDateTime.now();
        digging.setStartDigging(startTime);
        diggingRepository.save(digging);
    }

    @Override
    public Optional<Digging> get(Long id) {
        return diggingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Digging digging) {

    }

    public Digging addAndFlash(Digging digging) {
        LocalDateTime startTime = LocalDateTime.now();
        digging.setStartDigging(startTime);
        return diggingRepository.saveAndFlush(digging);
    }

}
