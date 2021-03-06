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

        String name = "Hemingway Special";

        boolean alcoholic = true;

        String taste = "Strong and sour";

        String flavourProfile = "Rum with zesty citrus notes";

        String method = "Put all ingredients into a shaker, " +
                        "add cubed ice and shake for about 10 seconds.\n\nFine strain into a clean, chilled glass " +
                        "and garnish.";

        String glass = "Martini / Coupe";

        String ice = "None";

        String garnish = "Lime wedge/wheel or cherry";

        Cocktail newCock = new Cocktail(name, alcoholic, taste, flavourProfile,
                                        method, glass, ice, garnish);

        newCock.addIngredient(new Ingredient("White rum", "45ml", "1.5oz", newCock));
        newCock.addIngredient(new Ingredient("Lime juice", "15ml", "1/2oz", newCock));
        newCock.addIngredient(new Ingredient("Grapefruit juice", "15ml", "1/2oz", newCock));
        newCock.addIngredient(new Ingredient("Maraschino Liqueur", "10ml", "1/3oz", newCock));
        newCock.addIngredient(new Ingredient("Simple syrup", "Dash", "Dash", newCock));

        cr.save(newCock);
    }

}
