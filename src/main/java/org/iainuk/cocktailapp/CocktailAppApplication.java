package org.iainuk.cocktailapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.iainuk.cocktailapp.dao.CocktailRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class CocktailAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(CocktailAppApplication.class, args);
    }

}
