package org.iainuk.cocktailapp;

import org.iainuk.cocktailapp.dao.CocktailRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CocktailAppApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(CocktailAppApplication.class, args);
        CocktailRepo cr = ctx.getBean("cocktailRepo", CocktailRepo.class);

        String name = "Gin Fizz";

        boolean alcoholic = true;

        String taste = "Sweet or Sour";

        String flavourProfile = "Refreshing crisp lemon";

        String method = "Add gin, lemon juice and syrup to a shaker, add cubed ice and shake for about 10 seconds.\n" +
                        "Strain into fresh glass with ice, top with soda water and garnish.\n";

        String glass = "Collins / Tall";

        String ice = "Cubed";

        String garnish = "Lemon twist/wedge";

        Cocktail newCock = new Cocktail(name, alcoholic, taste, flavourProfile,
                                        method, glass, ice, garnish);

        newCock.addIngredient(new Ingredient("Gin", "60ml", "2oz", newCock));
        newCock.addIngredient(new Ingredient("Lemon juice", "30ml", "1oz", newCock));
        newCock.addIngredient(new Ingredient("Simple syrup", "30ml", "1oz", newCock));
        newCock.addIngredient(new Ingredient("Soda water", "Top with", "Top with", newCock));

        cr.save(newCock);
    }

}
