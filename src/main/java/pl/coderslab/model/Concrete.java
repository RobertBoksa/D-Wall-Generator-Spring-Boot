package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "concrete")
public class Concrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime controlTime;

    @NotEmpty
    @PositiveOrZero
    private Double bentoniteHeight;

    @NotEmpty
    @PositiveOrZero
    private Double concreteValue;

    @ManyToOne
    private Section sectionCon;

}
