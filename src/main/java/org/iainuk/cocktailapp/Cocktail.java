package org.iainuk.cocktailapp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="cocktail")
public class Cocktail {

    int number = 12;

    String result = switch (number) {
        case 1, 2 -> "One or two";
        default -> "Unknown";
    };
}
