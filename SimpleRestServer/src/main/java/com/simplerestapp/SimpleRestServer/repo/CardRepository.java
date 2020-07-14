package com.simplerestapp.SimpleRestServer.repo;
 
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.simplerestapp.SimpleRestServer.model.Card;
 
public interface CardRepository extends CrudRepository<Card, Long> {
    List<Card> findByTitle(String title);
}