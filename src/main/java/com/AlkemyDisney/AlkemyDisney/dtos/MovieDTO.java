package com.AlkemyDisney.AlkemyDisney.dtos;

import com.AlkemyDisney.AlkemyDisney.Entitys.CharacterEntity;
import com.AlkemyDisney.AlkemyDisney.Entitys.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;

    private String img;

    private String title;

    private LocalDate creationDate;

    private Integer score;

    private List<CharacterDTO> characters;

    private Long genreId;

    private GenreEntity genre;


    public void setCharacters(List<CharacterEntity> characters) {
    }
}
