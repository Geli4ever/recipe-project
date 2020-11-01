package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.CategoryCommand;
import com.svetlicic.filip.recipeproject.model.Category;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory {

    @Synchronized
    @Nullable
    public Category convert(CategoryCommand categoryCommand){

        if (categoryCommand == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryCommand.getId());
        category.setCategoryName(categoryCommand.getCategoryName());
        return category;
    }
}
