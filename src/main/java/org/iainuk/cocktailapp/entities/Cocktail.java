package org.iainuk.cocktailapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name="taste")
    private String taste;

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

    @Column(name="main")
    private String main;

    @OneToMany(
            fetch=FetchType.LAZY,
            mappedBy="cocktail",
            cascade=CascadeType.ALL)
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient)
    {
        if (ingredients == null)
            ingredients = new ArrayList<>();

        ingredients.add(ingredient);
    }
}
