package com.AlkemyDisney.AlkemyDisney.controllers;

import com.AlkemyDisney.AlkemyDisney.dtos.MovieDTO;
import com.AlkemyDisney.AlkemyDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(){
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){ //la clase ResponseEntity me ayuda a resolver los response que necesite

        MovieDTO movieSave= movieService.save(movie);//llamo a la interfaz que luego implementara el metodo save

        return ResponseEntity.status(HttpStatus.CREATED).body(movieSave);//devuelvo el DTO(en el body), mediante la clase ResponseEntity.CREATED que la creacion fue exitosa
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
        MovieDTO movie = movieService.getById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/{id}/characters/{characterId}")
    public ResponseEntity<MovieDTO> addCharacter(@PathVariable Long id, @PathVariable Long characterId) {
        MovieDTO movie = movieService.addCharacter(id, characterId);
        return ResponseEntity.ok().body(movie);
    }

    @DeleteMapping("/{id}/characters/{characterId}")
    public ResponseEntity<MovieDTO> deleteCharacter(@PathVariable Long id, @PathVariable Long characterId) {
        MovieDTO movie = movieService.deleteCharacter(id, characterId);
        return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO movie, @PathVariable Long id) {
        MovieDTO result = movieService.update(id, movie);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
