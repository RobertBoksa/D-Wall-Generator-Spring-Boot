package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.model.Concrete;
import pl.coderslab.model.Section;
import pl.coderslab.repository.SectionRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        sectionRepository.save(theoreticalConcrete(section));
    }


    @Override
    public Optional<Section> get(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        section.get().getCageList().size();
        return section;
    }

    @Override
    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }


    @Override
    public void update(Section section) {
        sectionRepository.save(theoreticalConcrete(section));
    }

    @Transactional
    public void updateStartTime(Long id){
        Section section = sectionRepository.findById(id).orElseThrow();
        section.setSectionStart(LocalDateTime.now());
        sectionRepository.save(section);
    }

    public List<Section> sectionsNotEnd(int v1){
        return sectionRepository.findSectionsByStatus(v1);
    }

    public Section endSection(Long id){
        Section section = sectionRepository.findById(id).get();
        section.setStatus(2);
        try{
            List<Concrete> concreteList= section.getConcreteList();
            Concrete conctere = concreteList.stream().filter(c->c.getConcreteValue()!=null)
                    .sorted(Comparator.comparing(Concrete::getControlTime).reversed())
                    .findFirst().get();

            System.out.println(conctere);
            section.setSectionEnd(conctere.getControlTime());
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return section;
    }



    private Double concreteCalc(Section section) {
        return section.getSectionLength() * section.getSectionWidth() * section.getSectionDepth();
    }

    private Double stopSoil(Section section) {
        return 0.5 * (section.getSectionWidth() + 0.3 * section.getSectionWidth()) * 0.2 * section.getSectionWidth()
                * section.getSectionDepth();
    }

    private Section theoreticalConcrete(Section section){
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
        return section;
    }
}
