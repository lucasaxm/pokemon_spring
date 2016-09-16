package com.pika.service;

import com.pika.exceptions.BusinessException;
import com.pika.exceptions.ValidationException;
import com.pika.model.Bag;
import com.pika.model.Pokemon;
import com.pika.model.Trainer;
import com.pika.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by LU355846 on 9/16/2016.
 */

@Repository
public class TrainerService {

    @Autowired
    BagRepository bagRepository;

    public void addPokemon(Trainer trainer, Pokemon pokemon) throws ValidationException, BusinessException {
        try {
            if (trainer.getPokemons().contains(pokemon)) {
                throw new ValidationException("Pokemon already belongs to this trainer.");
            } else if (pokemon.getTrainer() != null){
                throw new BusinessException("Pokemon already belongs to another trainer.");
            } else {
                trainer.getPokemons().add(pokemon);
                pokemon.setTrainer(trainer);
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void setBag(Trainer trainer, Bag bag){
        try{
            Bag oldBag = trainer.getBag();
            // if its a new bag, deletes the old one
            if ( (oldBag != null) && (!oldBag.equals(bag)) ){
                // TODO: finish this method
                bagRepository.delete(oldBag);
            }
        }
        catch (Exception e){
            throw e;
        }
    }
}
