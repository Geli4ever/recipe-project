package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.UnitOfMeasureCommand;
import com.svetlicic.filip.recipeproject.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure {

    @Synchronized
    @Nullable
    public UnitOfMeasure convert(UnitOfMeasureCommand uomCommand){

        if (uomCommand == null) {
            return null;
        }

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uomCommand.getId());
        uom.setUom(uomCommand.getUom());
        return uom;
    }
}
