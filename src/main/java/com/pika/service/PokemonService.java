package com.pika.service;

import com.pika.exceptions.BusinessException;
import com.pika.model.Move;
import com.pika.model.Pokemon;
import org.springframework.stereotype.Service;

/**
 * Created by LU355846 on 9/16/2016.
 */

@Service
public class PokemonService {
    public void addMove(Pokemon pokemon, Move move) throws BusinessException {
        try {
            if (pokemon.getMoveset().contains(move)) {
                throw new BusinessException("Pokemon already knows this move.");
            } else {
                pokemon.getMoveset().add(move);
                move.addPokemon(pokemon);
            }
        }
        catch (Exception e){
            throw e;
        }
    }
}
