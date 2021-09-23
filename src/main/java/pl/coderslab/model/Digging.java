package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "digging")
public class Digging {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime startDigging;


    private LocalDateTime endDigging;

    @NotEmpty
    private String partName;


    @NotNull
    @DecimalMin("0.30")
    @DecimalMax("4.00")
    private Double partLength;

    @NotNull
    @ManyToOne
    private Section sectionDigg;


    @OneToMany(mappedBy = "digging", cascade = CascadeType.REMOVE)
    private List<LvlSoil> lvlSoilList = new ArrayList<>();
}
