package pl.coderslab.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "cage")
public class Cage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String cageName;

    @NotNull
    @DecimalMin("0.10")
    @DecimalMax("2.00")
    private Double cageWidth;

    @NotNull
    @DecimalMin("0.50")
    @DecimalMax("5.00")
    private Double cageLength;

    @NotNull
    @DecimalMin("1.00")
    private Double cageHeight;

    @NotNull
    @DecimalMin("0.10")
    private Double cageWeight;

    @NotNull
    private Double cageTopLvl;

    private Double cageBotLvl;

    @ManyToMany(mappedBy = "cageList")
    private List<Section> sectionList = new ArrayList<>();

}
