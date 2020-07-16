package com.simplerestapp.SimpleRestServer.service;

import com.simplerestapp.SimpleRestServer.model.State;
import com.simplerestapp.SimpleRestServer.repo.StateRepository;
import com.simplerestapp.SimpleRestServer.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepo;

    public List<State> getStates() {
        return stateRepo.findAll();
    }

    public Optional<State> getStateById(long stateId) {
        return stateRepo.findById(stateId);
    }

    public State createState(State state) {
        return stateRepo.save(state);
    }

    public State updateState(long stateId, State state) {
        // retrieve state info
        Optional<State> byIdState = stateRepo.findById(stateId);
        if(!byIdState.isPresent()) {
            System.out.println("State with id " + stateId + " does not exist");
            throw new ResourceNotFoundException("State with id " + stateId + " does not exist");
        }
        State state1 = byIdState.get();

        state1.setDescription(state.getDescription());
        state1.setLastModified(new Date(System.currentTimeMillis()));

        return stateRepo.save(state1);
    }
}