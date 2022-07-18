package com.AlkemyDisney.AlkemyDisney.services;

import com.AlkemyDisney.AlkemyDisney.dtos.CharacterDTO;

public interface CharacterService {

     CharacterDTO save(CharacterDTO dto);
     CharacterDTO getById(Long id);
     CharacterDTO update(Long id, CharacterDTO dto);
     void delete(Long id);

}
