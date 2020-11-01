package com.svetlicic.filip.recipeproject.services;

import com.svetlicic.filip.recipeproject.commands.RecipeCommand;
import com.svetlicic.filip.recipeproject.converters.RecipeCommandToRecipe;
import com.svetlicic.filip.recipeproject.converters.RecipeToRecipeCommand;
import com.svetlicic.filip.recipeproject.model.Recipe;
import com.svetlicic.filip.recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe getRecipe(Long id) {
        System.out.println(recipeRepository.findById(id).get().getIngredients().size());
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        return recipeToRecipeCommand.convert(recipeRepository.save(recipeCommandToRecipe.convert(recipeCommand)));
    }
}
