package com.svetlicic.filip.recipeproject.repositories;

import com.svetlicic.filip.recipeproject.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
