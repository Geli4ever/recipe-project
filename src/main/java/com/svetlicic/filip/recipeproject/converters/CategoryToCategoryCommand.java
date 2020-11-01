package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.CategoryCommand;
import com.svetlicic.filip.recipeproject.model.Category;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand {

    @Synchronized
    @Nullable
    public CategoryCommand convert(Category category){

        if (category == null) {
            return null;
        }

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(category.getId());
        categoryCommand.setCategoryName(category.getCategoryName());
        return categoryCommand;
    }
}
