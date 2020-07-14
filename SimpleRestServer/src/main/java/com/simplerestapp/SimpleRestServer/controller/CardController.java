package com.simplerestapp.SimpleRestServer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.simplerestapp.SimpleRestServer.model.Card;
import com.simplerestapp.SimpleRestServer.repo.CardRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class CardController {

    @Autowired
    CardRepository repository;

    @GetMapping("/cards")
    public List<Card> getAllCards() {
        System.out.println("Get all Cards...");

        List<Card> cards = new ArrayList<>();
        repository.findAll().forEach(cards::add);

        return cards;
    }

    @PostMapping("/cards/create")
    public Card postCard(@RequestBody Card card) {
        Card _card = repository.save(new Card(card.getTitle(), card.getDescription()));
        return _card;
    }

    @GetMapping("/cards/title/{id}")
    public List<Card> findByTitle(@PathVariable String title) {
        List<Card> cards = repository.findByTitle(title);
        return cards;
    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable("id") long id, @RequestBody Card card) {
        System.out.println("Update Card with ID = " + id + "...");

        Optional<Card> cardData = repository.findById(id);

        if(cardData.isPresent()) {
            Card _card = cardData.get();
            _card.setTitle(card.getTitle());
            _card.setDescription(card.getDescription());
            // _card.setStateCode(card.getStateCode());
            _card.setLastModified(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(repository.save(_card), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}