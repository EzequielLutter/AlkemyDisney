package com.AlkemyDisney.AlkemyDisney.Entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genero")
@Getter
@Setter
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genero_id")
    private Long id;

    private String nombre;

    private String imagen;

    @OneToMany()
    private Set <PeliSerieEntity> peliSerieAsociada;
}
