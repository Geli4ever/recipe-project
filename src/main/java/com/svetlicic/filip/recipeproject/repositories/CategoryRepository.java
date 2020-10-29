package com.svetlicic.filip.recipeproject.repositories;

import com.svetlicic.filip.recipeproject.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
