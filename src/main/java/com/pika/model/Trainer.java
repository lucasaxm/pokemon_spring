package com.pika.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU355846 on 8/26/2016.
 */

@Data
@NoArgsConstructor

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String city;

    @NotNull
    @Min(0)
    @Max(8)
    private Integer badges;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    List<Pokemon> pokemons = new ArrayList<>();
}
