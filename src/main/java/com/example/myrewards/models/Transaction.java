package com.example.myrewards.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Transaction extends AbstractEntity {

        @NotNull
        private BigDecimal amount;

     //   private long date;

        private int points;

        @ManyToOne(fetch = FetchType.LAZY)
        private User user;

    public Transaction(@NotNull BigDecimal amount, int points, User user) {
        this.amount = amount;
      //  this.date = date;
        this.points = points;
        this.user = user;
    }

    public Transaction() {
    }
}

