package com.AlkemyDisney.AlkemyDisney.controllers;

import com.AlkemyDisney.AlkemyDisney.dtos.CharacterBasicDTO;
import com.AlkemyDisney.AlkemyDisney.dtos.CharacterDTO;
import com.AlkemyDisney.AlkemyDisney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save (@RequestBody CharacterDTO character) {
        CharacterDTO result = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO>getById(@PathVariable Long id) {
        CharacterDTO character = characterService.getById(id);
        return ResponseEntity.ok(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update (@PathVariable Long id, @RequestBody CharacterDTO genre) {
        CharacterDTO result = characterService.update(id, genre);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
