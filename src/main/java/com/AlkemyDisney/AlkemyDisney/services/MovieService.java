package com.AlkemyDisney.AlkemyDisney.services;

import com.AlkemyDisney.AlkemyDisney.dtos.MovieDTO;

import java.util.List;

public interface MovieService {

     MovieDTO save (MovieDTO dto);//defino el metodo que luego la clase ServiceImpl va a implementar

     List<MovieDTO> getAllMovies();
      MovieDTO getById(Long id);
      MovieDTO addCharacter(Long id, Long characterId);
      MovieDTO deleteCharacter(Long id, Long characterId);
      MovieDTO update(Long id, MovieDTO dto);
      void delete(Long id);
}
