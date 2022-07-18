package com.AlkemyDisney.AlkemyDisney.Repositories;

import com.AlkemyDisney.AlkemyDisney.Entitys.GenreEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    List<GenreEntity> findAll(Specification<GenreEntity> spec);
}
