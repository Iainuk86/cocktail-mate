package org.iainuk.cocktailapp.dao;

import org.iainuk.cocktailapp.Cocktail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepo extends CrudRepository<Cocktail, Integer> {

    List<Cocktail> findAllByOrderByName();

}
