package com.simplerestapp.SimpleRestServer.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.simplerestapp.SimpleRestServer.model.Card;
 
public interface CardRepository extends JpaRepository<Card, Long> {

}