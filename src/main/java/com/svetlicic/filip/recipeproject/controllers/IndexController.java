package com.svetlicic.filip.recipeproject.controllers;

import com.svetlicic.filip.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndex(Model model){
        log.debug("Displaying recipes");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }


}
