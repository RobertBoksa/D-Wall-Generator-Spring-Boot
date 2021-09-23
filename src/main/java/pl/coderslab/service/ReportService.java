package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Digging;
import pl.coderslab.model.LvlSoil;
import pl.coderslab.model.Section;
import pl.coderslab.repository.ConcreteRepository;
import pl.coderslab.repository.LvlSoilRepository;
import pl.coderslab.repository.SectionRepository;

import java.util.*;

@Service
public class ReportService {

    private final ConcreteRepository concreteRepository;
    private final SectionRepository sectionRepository;
    private final LvlSoilRepository lvlSoilRepository;

    public ReportService(ConcreteRepository concreteRepository, SectionRepository sectionRepository, LvlSoilRepository lvlSoilRepository) {
        this.concreteRepository = concreteRepository;
        this.sectionRepository = sectionRepository;
        this.lvlSoilRepository = lvlSoilRepository;
    }

    public Double maxDepthDigg(Long id){
        Section section = sectionRepository.findById(id).get();
        List<LvlSoil> lvlSoilList = section.getDiggingList().get(0).getLvlSoilList();
        lvlSoilList.sort(Comparator.comparing(LvlSoil::getLvlBot).reversed());
        return lvlSoilList.get(0).getLvlBot();
    }

    public Map<Long, List<String>> getListSoil(Long id){
        Map<Long, List<String>> lvlString =  new HashMap<>();

        Section section = sectionRepository.findById(id).get();
        long z = 1;
        for (Digging d :section.getDiggingList()) {
            List<LvlSoil> fromRepo = lvlSoilRepository.findAllByDiggingId(d.getId());
            List<String> lvlStr = new ArrayList<>();
            for (LvlSoil s: fromRepo){
                for (int i = 0; i <= (s.getLvlBot()-s.getLvlTop()) * 2; i++) {
                   lvlStr.add(s.getSoil().getSoilName());
                }
            }
            lvlString.put(z,lvlStr);
            z++;
        }
        return lvlString;
    }

    public Long countConcrete(Long id){
       return concreteRepository.countConcrete(id);
    }

}
