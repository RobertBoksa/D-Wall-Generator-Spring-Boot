package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import pl.coderslab.validator.CageListNotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "section")
public class Section{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String sectionName;

    @NotNull
//    @Pattern(regexp = "\\d+.\\d{1,2}||\\d+", message = "must be a number ")

    @DecimalMin("0.50")
    @DecimalMax("10.00")
    private Double sectionLength;

    @NotNull
    @DecimalMin("0.10")
    @DecimalMax("2.00")
    private Double sectionWidth;

    @NotNull
    @DecimalMin("1.00")
    private Double sectionDepth;

    //this value will write when operator of crank start dogging section
    private LocalDateTime sectionStart;

    //this value will write when concrete finished
    private LocalDateTime sectionEnd;

    //start, next, ending
    private String sectionType;


    private Double theoreticalConcrete;


    @ManyToMany
    @JoinTable(name = "cage_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "cage_id"))
    @CageListNotEmpty
    private List<Cage> cageList = new ArrayList<>();

    @OneToMany(mappedBy = "sectionDigg", cascade = CascadeType.REMOVE)
    private List<Digging> diggingList = new ArrayList<>();

    @OneToMany(mappedBy = "sectionCon",cascade = CascadeType.REMOVE)
    private List<Concrete> concreteList = new ArrayList<>();






    @NotNull
    @Range(min = 0, max = 2)
    private int status; // 0 - not started, 1 - just doing, 2 - done

}
