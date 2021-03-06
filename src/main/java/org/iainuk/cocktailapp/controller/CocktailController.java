package org.iainuk.cocktailapp.controller;

import org.iainuk.cocktailapp.dao.CocktailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CocktailController {

    @Autowired
    private CocktailRepo cocktailRepo;

}
