package com.simplerestapp.SimpleRestServer.model;

import com.simplerestapp.SimpleRestServer.model.Card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "state")
public class State {

    @Id
    @Column(name = "id", nullable = false, length = 10)
    private long id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Card> cards = new HashSet<>();

    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    public State() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Set<Card> getCards() {
        return cards;
    }

    @JsonIgnore
    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @PrePersist
    protected void prePersist() {
        if (this.lastModified == null) 
            lastModified = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    protected void preUpdate() {
        this.lastModified = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "State [id=" + id + ", description=" + description + ", lastModified=" + lastModified + "]";
    }
}