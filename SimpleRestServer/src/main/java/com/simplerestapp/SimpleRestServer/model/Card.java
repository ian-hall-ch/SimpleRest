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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "state_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private State state;

    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    public Card() {
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

    public long getStateId() {
        return state.getId(); 
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
        return "Card [id=" + id + ", title=" + title + ", description=" + description + ", stateId=" + state.getId() + ", lastModifed=" + lastModified + "]";
    }
}