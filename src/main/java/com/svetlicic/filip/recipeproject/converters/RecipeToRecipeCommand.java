package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.CategoryCommand;
import com.svetlicic.filip.recipeproject.commands.IngredientCommand;
import com.svetlicic.filip.recipeproject.commands.RecipeCommand;
import com.svetlicic.filip.recipeproject.model.Category;
import com.svetlicic.filip.recipeproject.model.Ingredient;
import com.svetlicic.filip.recipeproject.model.Recipe;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeToRecipeCommand {

    private final CategoryToCategoryCommand categoryToCategoryCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final NotesToNotesCommand notesToNotesCommand;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryToCategoryCommand, IngredientToIngredientCommand ingredientToIngredientCommand, NotesToNotesCommand notesToNotesCommand) {
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.notesToNotesCommand = notesToNotesCommand;
    }

    @Synchronized
    @Nullable
    public RecipeCommand convert(Recipe recipe){

        if (recipe == null) {
            return null;
        }

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipeCommand.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setDirections(recipe.getDirections());
        Set<CategoryCommand> categoryCommands = new HashSet<>();
        for(Category category : recipe.getCategories()){
            categoryCommands.add(categoryToCategoryCommand.convert(category));
        }
        recipeCommand.setCategories(categoryCommands);
        Set<IngredientCommand> ingredientCommands = new HashSet<>();
        for(Ingredient ingredient : recipe.getIngredients()){
            ingredientCommands.add(ingredientToIngredientCommand.convert(ingredient));
        }
        recipeCommand.setIngredients(ingredientCommands);
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setNotes(notesToNotesCommand.convert(recipe.getNotes()));
        return recipeCommand;
    }
}
