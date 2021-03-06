package com.AlkemyDisney.AlkemyDisney.dtos;

import com.AlkemyDisney.AlkemyDisney.Entitys.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterDTO {

    private Long id;
    private String img;
    private String name;
    private Long age;
    private float weight;
    private String history;
    private List<MovieEntity> movies;

    public void setWeight(Double weight) {
    }

    public void setAge(Integer age) {
    }
}
