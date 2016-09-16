package com.pika.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LU355846 on 9/12/2016.
 */

@Data
@NoArgsConstructor
@ToString(exclude = "trainer")

@Entity
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer pokeballs = 0;

    @Column(nullable = false)
    private Integer potions = 0;

    @OneToOne
    private Trainer trainer;

}
