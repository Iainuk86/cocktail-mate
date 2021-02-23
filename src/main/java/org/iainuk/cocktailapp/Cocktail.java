package org.iainuk.cocktailapp;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private long id;

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
}
