package org.iainuk.cocktailapp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ingredient_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="quantity_m")
    private String quantityMetric;

    @Column(name="quantity_i")
    private String quantityImperial;

    @ManyToOne(
            fetch=FetchType.LAZY,
            cascade={CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="cocktail_id")
    private Cocktail cocktail;

    public Ingredient(String name, String metric, String imp, Cocktail cocktail)
    {
        this.name = name;
        this.quantityMetric = metric;
        this.quantityImperial = imp;
        this.cocktail = cocktail;
    }

    public String toString()
    {
        return quantityMetric + " " + name + ".";
    }
}
