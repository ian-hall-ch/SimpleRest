package com.simplerestapp.SimpleRestServer.model;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 10)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "state_code")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private State state;

    @Column(name = "last_modified")
    private Date last_modified;

    public Card() {
    }

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
        this.last_modified = new Date(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStateCode() {
        return state.getCode(); 
    }

    @JsonIgnore
    public State getState() {
        return state;
    }

    @JsonIgnore
    public void setState(State state) {
        this.state = state;
    }

    public Date getLastModified() {
        return last_modified;
    }

    public void setLastModified(Date last_modified) {
        this.last_modified = last_modified;
    }

    @Override
    public String toString() {
        return "Card [id=" + id + ", title=" + title + ", description=" + description + ", state=" + state.getCode() + ", last_modified=" + last_modified + "]";
    }
}