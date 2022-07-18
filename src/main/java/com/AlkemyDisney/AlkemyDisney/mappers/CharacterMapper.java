package com.AlkemyDisney.AlkemyDisney.mappers;

import com.AlkemyDisney.AlkemyDisney.Entitys.CharacterEntity;
import com.AlkemyDisney.AlkemyDisney.dtos.CharacterBasicDTO;
import com.AlkemyDisney.AlkemyDisney.dtos.CharacterDTO;
import com.AlkemyDisney.AlkemyDisney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;



    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
        CharacterEntity character = new CharacterEntity();
        character.setImg(dto.getImg());
        character.setName(dto.getName());
        character.setAge(dto.getAge());
        character.setWeight(dto.getWeight());
        character.setHistory(dto.getHistory());
        character.setMovies(dto.getMovies());
        return character;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies) {
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImg(entity.getImg());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        dto.setMovies(entity.getMovies());
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovies) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities) {
            dtos.add(this.characterEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }

    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        CharacterBasicDTO basicDTO;
        for (CharacterEntity entity : entities) {
            basicDTO = new CharacterBasicDTO();
            basicDTO.setImg(entity.getImg());
            basicDTO.setName(entity.getName());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtos) {
        List<CharacterEntity> entities = new ArrayList<>();
        for (CharacterDTO dto : dtos) {
            entities.add(this.characterDTO2Entity(dto));
        }
        return entities;
    }

    public void update(CharacterEntity entity, CharacterDTO dto) {
        entity.setImg(dto.getImg());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
    }

}
