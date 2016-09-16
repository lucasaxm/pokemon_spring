package com.pika.controller;

import com.google.gson.Gson;
import com.pika.enums.MoveCategory;
import com.pika.model.Bag;
import com.pika.model.Move;
import com.pika.model.Pokemon;
import com.pika.model.Trainer;
import com.pika.repository.BagRepository;
import com.pika.repository.MoveRepository;
import com.pika.repository.PokemonRepository;
import com.pika.repository.TrainerRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LU355846 on 9/12/2016.
 */

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    MoveRepository moveRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    BagRepository bagRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> create(){
        try{
            // TODO: come back here when all services are done
            Trainer trainer = new Trainer();
            trainer.setName("Ash");
            trainer.setCity("Pallet");
            trainer.setBadges(1);
            trainer = trainerRepository.save(trainer);

            Bag bag = new Bag();
            bag.setPokeballs(10);
            bag.setPotions(10);
            bag.setTrainer(null);
            bagRepository.save(bag);
            trainer.setBag(bag);

            Move move = new Move();
            move.setName("Tackle");
            move.setCategory(MoveCategory.PHYSICAL);
            moveRepository.save(move);

            Pokemon pokemon = new Pokemon();
            pokemon.setName("Pikachu");
            pokemon.addMove(move);
            pokemon.setTrainer(trainer);
            pokemonRepository.save(pokemon);

            trainer.addPokemon(pokemon);
            trainerRepository.save(trainer);
            return new ResponseEntity<>(trainer,HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
