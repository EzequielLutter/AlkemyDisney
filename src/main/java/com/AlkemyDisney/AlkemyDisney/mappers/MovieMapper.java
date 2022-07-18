package com.AlkemyDisney.AlkemyDisney.mappers;

import com.AlkemyDisney.AlkemyDisney.Entitys.MovieEntity;
import com.AlkemyDisney.AlkemyDisney.dtos.MovieBasicDTO;
import com.AlkemyDisney.AlkemyDisney.dtos.MovieDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity(MovieDTO dto){ //recibo un dto y lo convierto a entidad
    MovieEntity movieEntity = new MovieEntity();//creo una entidad para setearle el dto que traigo
    movieEntity.setImg(dto.getImg());
    movieEntity.setTitle(dto.getTitle());
    movieEntity.setCreationDate(dto.getCreationDate());
    movieEntity.setScore(dto.getScore());
    movieEntity.setCharacters(dto.getCharacters());
    movieEntity.setGenre(dto.getGenre());
    return movieEntity;//devuelvo mi entidad ya "mapeada" a partir del dto

    }

    public MovieDTO movieEntity2DTO(MovieEntity entity){ //recibo una entidad y lo mapeo a dto
        MovieDTO dto= new MovieDTO(); //creo el dto que luego voy a devolver ya seteado
        dto.setId(entity.getId());//en el caso del dto ya tengo que devolver el Id que se genero
        dto.setImg(entity.getImg());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate());
        dto.setScore(entity.getScore());
        dto.setCharacters(entity.getCharacters());
        dto.setGenre(entity.getGenre());
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity>entities){
        List<MovieDTO> dtos = new ArrayList<>(); //instancio mi lista de dtos
        for (MovieEntity entity:entities) { //utilizo un foreach para recorrer el ArrayList
            dtos.add(this.movieEntity2DTO(entity)); //agrego las entidades a mi lista de dtos
        }return dtos;//devuelvo la lista de dtos
    }
    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> entities) {
        List<MovieBasicDTO> dtos = new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (MovieEntity entity : entities) {
            basicDTO = new MovieBasicDTO();
            basicDTO.setImage(entity.getImg());
            basicDTO.setTitle(entity.getTitle());
            basicDTO.setCreationDate(entity.getCreationDate());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public List<MovieEntity> movieDetailedDTOList2EntityList(List<MovieDTO> dtos) {
        List<MovieEntity> entities = new ArrayList<>();
        for (MovieDTO dto : dtos) {
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    }

    public void update(MovieEntity entity, MovieDTO dto) {
        entity.setImg(dto.getImg());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(dto.getCreationDate());
        entity.setScore(dto.getScore());
        entity.setGenreId(dto.getGenreId());
    }

}
