package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotNull
    @DecimalMin("0.10")
    private Double bentoniteHeight;

    @NotNull
    @Min(1)
    private Integer concreteValue;

    @NotNull
    @ManyToOne
    private Section sectionCon;

}
