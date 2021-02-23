package org.iainuk.cocktailapp;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="cocktail_id")
    private long cocktailId;

    @Column(name="quantity_m")
    private double quantityMetric;

    @Column(name="quantity_i")
    private double quantityImperial;

}
