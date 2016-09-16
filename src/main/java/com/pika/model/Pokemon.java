package com.pika.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pika.exceptions.BusinessException;
import com.pika.exceptions.ValidationException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU355846 on 8/26/2016.
 */

@Data
@NoArgsConstructor
@ToString(exclude = "trainer")

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String nickname;

    @Column(nullable = false)
    @Min(0)
    @Max(386)
    private Integer pokedexNumber;

    @Column(nullable = false)
    private Integer nMoves;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JsonIgnore
    private Trainer trainer;

    @ManyToMany
    private List<Move> moveset = new ArrayList<>();
}
