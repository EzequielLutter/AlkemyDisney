package com.AlkemyDisney.AlkemyDisney.Entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String imagen;

    private String nombre;

    private Integer edad;

    private Double peso;

    private String historia;

    @ManyToMany(mappedBy = "personajesAsociados", cascade = CascadeType.ALL)
    private Set<PeliSerieEntity> peliSerie = new HashSet<>();


}
