package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.UnitOfMeasureCommand;
import com.svetlicic.filip.recipeproject.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand {

    @Synchronized
    @Nullable
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure){

        if (unitOfMeasure == null) {
            return null;
        }

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(unitOfMeasure.getId());
        unitOfMeasureCommand.setUom(unitOfMeasure.getUom());
        return unitOfMeasureCommand;
    }
}
