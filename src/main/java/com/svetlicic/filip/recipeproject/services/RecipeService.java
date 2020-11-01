package com.svetlicic.filip.recipeproject.services;

import com.svetlicic.filip.recipeproject.commands.RecipeCommand;
import com.svetlicic.filip.recipeproject.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe getRecipe(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
