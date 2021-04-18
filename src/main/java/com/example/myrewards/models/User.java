package com.example.myrewards.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL,
            orphanRemoval = true)
    private final List<Transaction> transactions = new ArrayList<>();

    public User( String name) {
        this.name = name;
    }

    public User() {

    }
}
