package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private Double startLvl;

    private Double endLvl;

    private String partName;

    private Double partLength;

    @ManyToOne
    @JoinColumn(name = "soil_id")
    private Soil soil;

    @ManyToOne
    private Section section;

}
