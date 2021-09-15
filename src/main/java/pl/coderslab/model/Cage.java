package pl.coderslab.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    private Double cageWidth;

    @NotEmpty
    private Double cageLength;

    @NotEmpty
    private Double cageHeight;

    @NotEmpty
    private Double cageWeight;

    @NotEmpty
    private Double cageTopLvl;

    @NotEmpty
    private Double cageBotLvl;

    @ManyToMany(mappedBy = "cageList", cascade = CascadeType.REMOVE)
    private List<Section> sectionList = new ArrayList<>();


}
