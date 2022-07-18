package com.AlkemyDisney.AlkemyDisney.services.impl;

import com.AlkemyDisney.AlkemyDisney.Entitys.CharacterEntity;
import com.AlkemyDisney.AlkemyDisney.Repositories.CharacterRepository;
import com.AlkemyDisney.AlkemyDisney.dtos.CharacterDTO;
import com.AlkemyDisney.AlkemyDisney.mappers.CharacterMapper;
import com.AlkemyDisney.AlkemyDisney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;
;

    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity character = characterMapper.characterDTO2Entity(dto);
        CharacterEntity new_character = characterRepository.save(character);
        CharacterDTO result = characterMapper.characterEntity2DTO(new_character, true);
        return result;
    }

    public CharacterDTO getById(Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {

        }
        CharacterDTO character = characterMapper.characterEntity2DTO(entity.get(), true);
        return character;
    }

    public CharacterDTO update(Long id, CharacterDTO dto) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {

        }
        characterMapper.update(entity.get(), dto);
        characterRepository.save(entity.get());
        CharacterDTO result = characterMapper.characterEntity2DTO(entity.get(), true);
        return result;
    }

    public void delete(Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);

        characterRepository.delete(entity.get());
    }

}




