package com.AlkemyDisney.AlkemyDisney.Repositories;

import com.AlkemyDisney.AlkemyDisney.Entitys.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//los repositorios deben ser de tipo interface para que no sea necesario implementar todos los metodos.
public interface MovieRepository extends JpaRepository<MovieEntity, Long> { //implementamos la clase JpaRepository que me provee los metodos basicos de CRUD. necesitamos pasarle la entidad con la que vamos a trabajar y el tipo de clave que posee


    List<MovieEntity> findAll(Specification<MovieEntity> spec);
}
