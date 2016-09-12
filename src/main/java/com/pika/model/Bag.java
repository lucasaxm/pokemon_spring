package com.pika.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by LU355846 on 9/12/2016.
 */

@Data
@NoArgsConstructor

@Entity
public class Bag {

    @NotNull
    private Integer pokeballs = 0;

    @NotNull
    private Integer potions = 0;

    @OneToOne
    private Trainer trainer;
}
