package com.pika.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.pika.enums.MoveCategory;
import com.pika.enums.MoveTypes;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU355846 on 8/26/2016.
 */

@Data
@NoArgsConstructor

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MoveTypes type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MoveCategory category;

    @ManyToMany
    private List<Pokemon> pokemonList = new ArrayList<>();

}
