package org.iainuk.cocktailapp.controller;

import org.iainuk.cocktailapp.Cocktail;
import org.iainuk.cocktailapp.dao.CocktailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class CocktailController {

    @Autowired
    private CocktailRepo cocktailRepo;

    @GetMapping("/cocktail-single")
    public String showSingle(@RequestParam("id") int id, Model model) {

        Cocktail cocktail = cocktailRepo.findById(id).get();

        model.addAttribute("cocktail", cocktail);

        return "cocktail-single";
    }

    @GetMapping("/random")
    public String showRandom(Model model)
    {
        Random random = new Random();
        int id = random.nextInt(62);

        return "redirect:/cocktail-single?id=" + id;
    }

    @GetMapping("/cocktails")
    public String showCocktails(Model model)
    {
        Iterable<Cocktail> cocktails = cocktailRepo.findAll();

        model.addAttribute("cocktails", cocktails);

        return "cocktails";
    }

    @PostMapping("/cocktails")
    public String searchQuery(@ModelAttribute("keyword") String keyword, Model model)
    {
        List<Cocktail> cocktails = null;

        if (keyword == null) {
            cocktails = cocktailRepo.findAll();
        } else if (keyword.matches("(?i)whiskey|gin|rum|vodka|tequila|brandy|alcohol free")) {
            cocktails = cocktailRepo.searchByMain(keyword);
        } else {
            cocktails = cocktailRepo.search(keyword);
        }

        model.addAttribute("cocktails", cocktails);

        return "cocktails";
    }
}
