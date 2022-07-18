package com.AlkemyDisney.AlkemyDisney.services.impl;

import com.AlkemyDisney.AlkemyDisney.Entitys.GenreEntity;
import com.AlkemyDisney.AlkemyDisney.Repositories.GenreRepository;
import com.AlkemyDisney.AlkemyDisney.dtos.GenreDTO;
import com.AlkemyDisney.AlkemyDisney.mappers.GenreMapper;
import com.AlkemyDisney.AlkemyDisney.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepo;

    public GenreDTO save(GenreDTO dto) {
        GenreEntity genre = genreMapper.genreDTO2Entity(dto);
        GenreEntity new_genre = genreRepo.save(genre);
        GenreDTO result = genreMapper.genreEntity2DTO(new_genre);
        return result;
    }


    public GenreDTO getDetailsById(Long id) {
        Optional<GenreEntity> entity = genreRepo.findById(id);
        if (entity.isPresent()) {
            GenreDTO dto = genreMapper.genreEntity2DTO(entity.get());
            return dto;
        }
        return null;
    }

}

