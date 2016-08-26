package com.pika.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by LU355846 on 8/26/2016.
 */

@Data
@NoArgsConstructor

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    private String nickname;

    @NotNull
    @Min(0)
    @Max(386)
    @Column(name = "pokedex_number")
    private Integer pokedexNumber;

    @NotNull
    @Column(name = "n_moves")
    private Integer nMoves;

    @NotNull
    private String type;

    @ManyToOne
    private Trainer trainer;
}
