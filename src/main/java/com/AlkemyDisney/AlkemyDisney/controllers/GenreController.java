package com.AlkemyDisney.AlkemyDisney.controllers;

import com.AlkemyDisney.AlkemyDisney.dtos.GenreDTO;
import com.AlkemyDisney.AlkemyDisney.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> save (@RequestBody GenreDTO genre) {
        GenreDTO new_genre = genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(new_genre);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getDetailsById(@PathVariable Long id) {
        GenreDTO genre = this.genreService.getDetailsById(id);
        return ResponseEntity.ok(genre);
    }

}
