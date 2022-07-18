package com.AlkemyDisney.AlkemyDisney.services.impl;

import com.AlkemyDisney.AlkemyDisney.Entitys.CharacterEntity;
import com.AlkemyDisney.AlkemyDisney.Entitys.MovieEntity;
import com.AlkemyDisney.AlkemyDisney.Repositories.CharacterRepository;
import com.AlkemyDisney.AlkemyDisney.Repositories.MovieRepository;
import com.AlkemyDisney.AlkemyDisney.dtos.MovieDTO;
import com.AlkemyDisney.AlkemyDisney.mappers.MovieMapper;
import com.AlkemyDisney.AlkemyDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper; //definimos el autowired para que Springboot inyecte el mapper cuando sea necesario

    @Autowired
    private MovieRepository movieRepository; //definimos el mapper de la misma manera que el mapper, para utilizar cuando sea necesario.

    @Autowired
    private CharacterRepository characterRepository; //definimos el repositorio a inyectar

    public MovieDTO save(MovieDTO dto){

        MovieEntity entity = movieMapper.movieDTO2Entity(dto); //creo una entidad, llamo al mapper, que va a implementar el metodo para convertir el dto a entity
        MovieEntity entitySaved= movieRepository.save(entity); //le paso el dto mapeado a entity al repositorio para que lo guarde en la BD. y a su vez, recupero la entidad guardada con el ID generado
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved); //creo el dto que voy a devolver (result) le mando la entidad guardada al mapper para que me la devuelva mapeada a dto
        return result;//devuelvo el dto ya mapeado a partir de la entidad persistida ocn todos sus atributos
    }


    public List<MovieDTO> getAllMovies() {//implemento el metodo para recuperar una lista de peliculas o series
        List<MovieEntity> entities = movieRepository.findAll(); //metodo proveido por JpaRepository para recuperar toda la lista de peliculas
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities);//llamo al metodo del mapper para que me mapee las entities a dtos que pueda devolver
        return result; //devuelvo el result con la lista de dtos
    }

    public MovieDTO getById(Long id) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {

        }
        MovieDTO movie = movieMapper.movieEntity2DTO(entity.get());

        return movie;
    }

    @Override
    public MovieDTO addCharacter(Long id, Long characterId) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {

        }
        MovieEntity movie = movieOptional.get();
        Optional<CharacterEntity> characterOptional = characterRepository.findById(characterId);
        if (!characterOptional.isPresent()) {

        }
        CharacterEntity character = characterOptional.get();
        movie.getCharacters().add(character);
        movieRepository.save(movie);
        MovieDTO result = movieMapper.movieEntity2DTO(movie);
        return result;
    }

    public MovieDTO deleteCharacter(Long id, Long characterId) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {

        }
        MovieEntity movie = movieOptional.get();
        Optional<CharacterEntity> characterOptional = characterRepository.findById(characterId);
        if (!characterOptional.isPresent()) {

        }
        CharacterEntity character = characterOptional.get();
        movie.getCharacters().remove(character);
        movieRepository.save(movie);
        MovieDTO movie2 = movieMapper.movieEntity2DTO(movie);
        return movie2;
    }

    public MovieDTO update(Long id, MovieDTO dto) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {

        }
        movieMapper.update(entity.get(), dto);
        movieRepository.save(entity.get());
        MovieDTO result = movieMapper.movieEntity2DTO(entity.get());
        return result;
    }

    public void delete(Long id) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {

        }
        movieRepository.deleteById(id);
    }
}
