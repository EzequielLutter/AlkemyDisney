package com.AlkemyDisney.AlkemyDisney.Entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String img;

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    @ManyToMany(mappedBy = "characters",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<MovieEntity> movies = new ArrayList<>();


    private boolean deleted = Boolean.FALSE;




    public void setAge(Long age) {
    }

    public void setWeight(float weight) {
    }
}
