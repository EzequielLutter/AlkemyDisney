package com.AlkemyDisney.AlkemyDisney.mappers;

import com.AlkemyDisney.AlkemyDisney.Entitys.GenreEntity;
import com.AlkemyDisney.AlkemyDisney.dtos.GenreDTO;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO dto) {
        GenreEntity genre = new GenreEntity();
        genre.setImg(dto.getImg());
        genre.setName(dto.getName());
        return genre;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity) {
        GenreDTO dto = new GenreDTO();
        dto.setId(entity.getId());
        dto.setImg(entity.getImg());
        dto.setName(entity.getName());
        return dto;
    }

}
