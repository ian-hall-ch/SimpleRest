package com.simplerestapp.SimpleRestServer.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.simplerestapp.SimpleRestServer.model.State;
 
public interface StateRepository extends JpaRepository<State, Long> {

}