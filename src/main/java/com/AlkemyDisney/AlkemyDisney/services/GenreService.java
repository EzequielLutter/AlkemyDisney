package com.AlkemyDisney.AlkemyDisney.services;

import com.AlkemyDisney.AlkemyDisney.dtos.GenreDTO;

public interface GenreService {

     GenreDTO save(GenreDTO dto);
     GenreDTO getDetailsById(Long id);
}
