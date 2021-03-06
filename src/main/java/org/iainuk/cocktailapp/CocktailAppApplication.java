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

        String name = "";

        boolean alcoholic = true;

        String flavourProfile = "";

        String method = "";

        String glass = "";

        String ice = "";

        String garnish = "";
    }

}
