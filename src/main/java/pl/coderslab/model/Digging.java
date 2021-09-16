package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private String partName;

    @NotNull
    @DecimalMin("0.30")
    private Double partLength;

    @ManyToOne
    private Section sectionDigg;

    @OneToMany(mappedBy = "digging")
    private List<LvlSoil> lvlSoilList = new ArrayList<>();
}
