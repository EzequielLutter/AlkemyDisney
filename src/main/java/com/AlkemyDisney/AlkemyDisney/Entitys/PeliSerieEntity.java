package com.AlkemyDisney.AlkemyDisney.Entitys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "peli_serie")
@Getter
@Setter
public class PeliSerieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Integer calificacion;

    @Column(name = "personajes_asociados")
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "personaje_peli_serie",
            joinColumns = @JoinColumn(name = "peli_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Set <PersonajeEntity> personajesAsociados= new HashSet<>();


}
