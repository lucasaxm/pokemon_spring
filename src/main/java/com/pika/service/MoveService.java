package com.pika.service;

import com.pika.exceptions.BusinessException;
import com.pika.exceptions.ValidationException;
import com.pika.model.Move;
import com.pika.model.Pokemon;
import org.springframework.stereotype.Repository;

import javax.persistence.NonUniqueResultException;

/**
 * Created by LU355846 on 9/16/2016.
 */

@Repository
public class MoveService {
    public void addPokemon(Move move, Pokemon pokemon) throws ValidationException {
        try {
            if (move.getPokemons().contains(pokemon)) {
                throw new ValidationException("The move already belongs to this Pokemon.");
            } else {
                move.getPokemons().add(pokemon);
            }
        }
        catch (Exception e){
            throw e;
        }
    }
}
