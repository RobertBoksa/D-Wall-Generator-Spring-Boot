package pl.coderslab.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "lvlSoil")
public class LvlSoil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lvlTop;

    private Double lvlBot;

    @ManyToOne
    @JoinColumn(name = "soil_id")
    private Soil soil;

    @ManyToOne
    private Digging digging;

}
