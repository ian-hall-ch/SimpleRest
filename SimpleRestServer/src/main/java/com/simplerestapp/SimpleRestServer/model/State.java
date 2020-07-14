package com.simplerestapp.SimpleRestServer.model;
 
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import com.simplerestapp.SimpleRestServer.model.Card;

@Entity
@Table(name = "state")
public class State {

    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "description")
    private String description;

    @Column(name = "last_modified")
    private Date last_modified;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Card> cards = new HashSet<>();

    public State() {
    }

    public State(int code, String description) {
        this.code = code;
        this.description = description;
        this.last_modified = new Date(System.currentTimeMillis());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastModified() {
        return last_modified;
    }

    public void setLastModified(Date last_modified) {
        this.last_modified = last_modified;
    }

    @Override
    public String toString() {
        return "State [code=" + code + ", description=" + description + ", last_modified=" + last_modified + "]";
    }
}