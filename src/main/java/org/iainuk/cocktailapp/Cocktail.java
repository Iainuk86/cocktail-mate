package org.iainuk.cocktailapp;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cocktail_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="alcoholic")
    private boolean alcoholic;

    @Column(name="flavour_profile")
    private String flavourProfile;

    @Column(name="method")
    private String method;

    @Column(name="glass")
    private String glass;

    @Column(name="ice")
    private String ice;

    @Column(name="garnish")
    private String garnish;

    @OneToMany(
            fetch=FetchType.LAZY,
            mappedBy="cocktail",
            cascade=CascadeType.ALL)
    private List<Ingredient> ingredients;

    private void addIngredient(Ingredient ingredient)
    {
        if (ingredients == null)
            ingredients = new ArrayList<>();

        ingredients.add(ingredient);
    }
}
