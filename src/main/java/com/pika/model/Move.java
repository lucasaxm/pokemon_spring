package com.pika.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pika.enums.MoveCategory;
import com.pika.enums.MoveTypes;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU355846 on 8/26/2016.
 */

@Data
@NoArgsConstructor
@ToString(exclude = "pokemons")

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MoveTypes type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MoveCategory category;

    @ManyToMany
    @JsonIgnore
    private List<Pokemon> pokemons = new ArrayList<>();

}
