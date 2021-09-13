package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionName;

    private Double sectionLength;

    private Double sectionWidth;

    private Double sectionDepth;

    //this value will write when operator of crank start dogging section
    private LocalDateTime sectionStart;

    //this value will write when concrete finished
    private LocalDateTime sectionEnd;

    //start, next, ending
    private String sectionType;

    private Integer numOfCages;


    private Double theoreticalConcrete;

    @ManyToMany
    @JoinTable(name = "cage_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "cage_id"))
    private List<Cage> cageList = new ArrayList<>();

    @OneToMany(mappedBy = "section")
    private List<Digging> diggingList = new ArrayList<>();






    private int status; // 0 - not started, 1 - just doing, 2 - done

}
