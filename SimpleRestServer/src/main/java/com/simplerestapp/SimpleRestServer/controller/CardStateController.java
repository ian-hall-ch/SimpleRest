package com.simplerestapp.SimpleRestServer.controller;

import com.simplerestapp.SimpleRestServer.model.*;
import com.simplerestapp.SimpleRestServer.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;


@RestController
@RequestMapping("/v1")
public class CardStateController {

    @Autowired
    CardService cardService;

    @Autowired
    StateService stateService;

    // State mappings
    @RequestMapping(value = "/states", method = RequestMethod.GET)
    public List<State> getAllStates() {
        System.out.println("Get all States...");

        return stateService.getStates();
    }

    @RequestMapping(value = "/state/{stateId}", method = RequestMethod.GET)
    public Optional<State> findStateById(@PathVariable(value = "stateId") long stateId) {
        System.out.println("Get State by Id: " + stateId);
        
        return stateService.getStateById(stateId);
    }

    @RequestMapping(value = "/state", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public State createState(@RequestBody State state) {
        System.out.println("Creating State: " + state.getId());

        return stateService.createState(state);
    }

    @RequestMapping(value = "/state/{stateId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public State updateState(@PathVariable(value = "stateId") long stateId, @RequestBody State state) {
        System.out.println("Update State...");
        
        return stateService.updateState(stateId, state);
    }

    // Card mappings
    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<Card> getAllCards() {
        System.out.println("Get all Cards...");

        return cardService.getCards();
    }

    @RequestMapping(value = "/card/{cardId}", method = RequestMethod.GET)
    public Optional<Card> findByCardId(@PathVariable(value = "cardId") long cardId) {
        System.out.println("Get Card by Id: " + cardId);

        return cardService.getCardById(cardId);
    }

    @RequestMapping(value = "/{stateId}/card", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Card createCard(@PathVariable(value = "stateId") long stateId, @RequestBody Card card) {
        System.out.println("Creating Card...");
        
        return cardService.createCard(stateId, card);
    }

    @RequestMapping(value = "/card/{cardId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Card updateCard(@PathVariable(value = "cardId") long cardId, @RequestBody Card card) {
        System.out.println("Update Card...");
        
        return cardService.updateCard(cardId, card);
    }
}