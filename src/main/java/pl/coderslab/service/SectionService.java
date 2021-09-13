package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.model.Section;
import pl.coderslab.repository.SectionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SectionService implements ServiceForAll<Section, Long> {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    @Transactional
    @Override
    public List<Section> getAll() {
        List<Section> sections = sectionRepository.findAll();
        sections.forEach(c -> c.getCageList().size());
        sections.forEach(d -> d.getDiggingList().size());
        return sections;
    }

    @Override
    public void add(Section section) {
        Double concrete;
        if (section.getSectionType().equals("o")) {
            concrete = concreteCalc(section) - 2 * stopSoil(section);
            section.setTheoreticalConcrete(concrete);
        } else if (section.getSectionType().equals("n")) {
            concrete = concreteCalc(section) - stopSoil(section);
            section.setTheoreticalConcrete(concrete);
        } else {
            concrete = concreteCalc(section);
            section.setTheoreticalConcrete(concrete);
        }
        sectionRepository.save(section);
    }


    @Override
    public Optional<Section> get(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        section.get().getCageList().size();
        return section;
    }

    @Override
    public void delete(Long id) {
        Section section = get(id).orElseThrow();
        sectionRepository.delete(section);
    }


    @Override
    public void update(Section section) {
        sectionRepository.save(section);
    }

    public List<Section> sectionsNotEnd(int v1, int v2){
        return sectionRepository.findSectionsByStatusBetween(v1, v2);
    }




    private Double concreteCalc(Section section) {
        return section.getSectionLength() * section.getSectionWidth() * section.getSectionDepth();
    }

    private Double stopSoil(Section section) {
        return 0.5 * (section.getSectionWidth() + 0.3 * section.getSectionWidth()) * 0.2 * section.getSectionWidth()
                * section.getSectionDepth();
    }
}
