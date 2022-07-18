package com.AlkemyDisney.AlkemyDisney.Entitys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
@SQLDelete(sql = "UPDATE genre SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genre_id")
    private Long id;

    private String name;

    private String img;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<MovieEntity> movies;

    private boolean deleted = Boolean.FALSE;
}
