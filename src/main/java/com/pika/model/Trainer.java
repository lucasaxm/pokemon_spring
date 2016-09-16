package com.pika.model;

import com.pika.exceptions.BusinessException;
import com.pika.exceptions.ValidationException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    @Min(0)
    @Max(8)
    private Integer badges;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    private List<Pokemon> pokemons = new ArrayList<>();

    @OneToOne
    @Column(nullable = false)
    private Bag bag;
}
