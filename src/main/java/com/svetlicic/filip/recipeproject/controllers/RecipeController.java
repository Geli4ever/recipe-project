package com.svetlicic.filip.recipeproject.controllers;

import com.svetlicic.filip.recipeproject.commands.RecipeCommand;
import com.svetlicic.filip.recipeproject.model.Ingredient;
import com.svetlicic.filip.recipeproject.model.Recipe;
import com.svetlicic.filip.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showRecipe(@PathVariable Long id, Model model){
        if(recipeService.getRecipe(id) != null){
            Recipe recipe = recipeService.getRecipe(id);
            for(Ingredient ingredient : recipe.getIngredients()){
                log.debug(ingredient.getDescription());
            }
            model.addAttribute("recipe", recipe);
        } else {
            throw new RuntimeException("No Recipe");
        }
        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipe){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipe);
        return "redirect:/recipe/show/" + savedCommand.getId();
    }
}
