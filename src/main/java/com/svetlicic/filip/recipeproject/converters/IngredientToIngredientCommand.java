package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.IngredientCommand;
import com.svetlicic.filip.recipeproject.model.Ingredient;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand {

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Synchronized
    @Nullable
    public IngredientCommand convert(Ingredient ingredient){

        if (ingredient == null) {
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUnit(unitOfMeasureToUnitOfMeasureCommand.convert(ingredient.getUnitOfMeasure()));
        return ingredientCommand;
    }
}
