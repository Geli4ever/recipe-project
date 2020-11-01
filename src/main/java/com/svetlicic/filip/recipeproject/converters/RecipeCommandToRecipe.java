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
public class RecipeCommandToRecipe {

    private final CategoryCommandToCategory categoryCommandToCategory;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryCommandToCategory, IngredientCommandToIngredient ingredientCommandToIngredient, NotesCommandToNotes notesCommandToNotes) {
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Synchronized
    @Nullable
    public Recipe convert(RecipeCommand recipeCommand){
        System.out.println(recipeCommand);

        if (recipeCommand == null) {
            return null;
        }

        Recipe recipe = new Recipe();
        if(recipeCommand.getId() != null){
            recipe.setId(recipeCommand.getId());
        }
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setDirections(recipeCommand.getDirections());
        Set<Category> categories = new HashSet<>();
        for(CategoryCommand categoryCommand : recipeCommand.getCategories()){
            categories.add(categoryCommandToCategory.convert(categoryCommand));
        }
        recipe.setCategories(categories);
        Set<Ingredient> ingredients = new HashSet<>();
        for(IngredientCommand ingredientCommand : recipeCommand.getIngredients()){
            ingredients.add(ingredientCommandToIngredient.convert(ingredientCommand));
        }
        recipe.setIngredients(ingredients);
        recipe.setDifficulty(recipeCommand.getDifficulty());

        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotes()));
        return recipe;
    }
}
