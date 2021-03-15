package org.iainuk.cocktailapp.dao;

import org.iainuk.cocktailapp.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepo extends JpaRepository<Cocktail, Integer> {

    List<Cocktail> findAllByOrderByName();

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(:keyword), '%')")
    List<Cocktail> search(@Param("keyword") String keyword);

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.main) LIKE CONCAT('%', LOWER(:keyword), '%')")
    List<Cocktail> searchByMain(@Param("keyword") String keyword);

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.main) NOT IN ('whiskey', 'rum', 'gin', 'vodka', 'brandy', 'tequila')")
    List<Cocktail> searchNoStrongSpirits();

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.taste) LIKE CONCAT('%', LOWER(:taste), '%')" +
            "AND LOWER(c.main) LIKE LOWER(:spirit)" +
            "AND LOWER(c.flavourProfile) LIKE '%refresh%'")
    List<Cocktail> helperQueryAlcoholicHot(String taste, String spirit);

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.taste) LIKE CONCAT('%', LOWER(:taste), '%')" +
            "AND LOWER(c.main) LIKE LOWER(:spirit)" +
            "AND LOWER(c.flavourProfile) NOT LIKE '%refresh%'")
    List<Cocktail> helperQueryAlcoholicCold(String taste, String spirit);

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.taste) LIKE CONCAT('%', LOWER(:taste), '%')" +
            "AND LOWER(c.main) NOT IN ('whiskey', 'rum', 'gin', 'vodka', 'brandy', 'tequila')" +
            "AND LOWER(c.flavourProfile) LIKE '%refresh%'")
    List<Cocktail> helperQueryNonAlcoholicHot(String taste);

    @Query("SELECT c FROM Cocktail c WHERE LOWER(c.taste) LIKE CONCAT('%', LOWER(:taste), '%')" +
            "AND LOWER(c.main) NOT IN ('whiskey', 'rum', 'gin', 'vodka', 'brandy', 'tequila')" +
            "AND LOWER(c.flavourProfile) NOT LIKE '%refresh%'")
    List<Cocktail> helperQueryNonAlcoholicCold(String taste);

}
