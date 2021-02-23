package org.iainuk.cocktailapp.dao;

import org.iainuk.cocktailapp.Cocktail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CocktailRepo extends CrudRepository<Cocktail, Integer> {

    List<Cocktail> findAllByOrderByName();

}
