package com.pika.model;

import javax.persistence.*;

/**
 * Created by LU355846 on 8/26/2016.
 */

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated()
    private MoveTypes type;

}
