package com.simplerestapp.SimpleRestServer.service;

import com.simplerestapp.SimpleRestServer.model.Card;
import com.simplerestapp.SimpleRestServer.model.State;
import com.simplerestapp.SimpleRestServer.repo.CardRepository;
import com.simplerestapp.SimpleRestServer.repo.StateRepository;
import com.simplerestapp.SimpleRestServer.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Date;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepo;

    @Autowired
    StateRepository stateRepo;

    public List<Card> getCards() {
        return cardRepo.findAll();
    }

    public Optional<Card> getCardById(long cardId) {
        return cardRepo.findById(cardId);
    }

    public Card createCard(long stateId, Card card) {
        Set<Card> cards = new HashSet<>();
        State state1 = new State();

        Optional<State> byId = stateRepo.findById(stateId);
        if(!byId.isPresent()) {
            System.out.println("State with id " + stateId + " does not exist");
            throw new ResourceNotFoundException("State with id " + stateId + " does not exist");
        }
        State state = byId.get();

        // attach State to Card
        card.setState(state);
        Card card1 = cardRepo.save(card);

        // attach Card to State
        cards.add(card1);
        state1.setCards(cards);

        return card1;
    }

    public Card updateCard(long cardId, Card card) {
        // retrieve Card info
        Optional<Card> byIdCard = cardRepo.findById(cardId);
        if(!byIdCard.isPresent()) {
            System.out.println("Card with id " + cardId + " does not exist");
            throw new ResourceNotFoundException("Card with id " + cardId + " does not exist");
        }
        Card card1 = byIdCard.get();

        // look up State
        long stateId = card1.getStateId();
        Optional<State> byIdState = stateRepo.findById(stateId);
        if(!byIdState.isPresent()) {
            System.out.println("State with id " + stateId + " does not exist");
            throw new ResourceNotFoundException("State with id " + stateId + " does not exist");
        }
        State state = byIdState.get();

        card1.setTitle(card.getTitle());
        card1.setDescription(card.getDescription());
        card1.setState(state);
        card1.setLastModified(new Date(System.currentTimeMillis()));

        return cardRepo.save(card1);
    }
}