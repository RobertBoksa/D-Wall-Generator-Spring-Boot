package pl.coderslab.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    private String cageName;

    private Double cageWidth;

    private Double cageLength;

    private Double cageHeight;

    private Double cageWeight;

    private Double cageTopLvl;

    private Double cageBotLvl;

    @ManyToMany(mappedBy = "cageList")
    private List<Section> sectionList = new ArrayList<>();


}
