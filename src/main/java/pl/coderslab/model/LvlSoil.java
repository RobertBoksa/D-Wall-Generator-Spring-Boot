package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "lvlSoil")
public class LvlSoil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin("0.00")
    private Double lvlTop;

    @NotNull
    @DecimalMin("0.10")
    private Double lvlBot;

    @ManyToOne
    @JoinColumn(name = "soil_id")
    private Soil soil;

    @ManyToOne
    private Digging digging;

}
