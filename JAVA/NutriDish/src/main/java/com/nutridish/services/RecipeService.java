package com.nutridish.services;

import com.nutridish.entities.RecipeEntity;
import com.nutridish.repositories.RecipeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeEntity> getRecipes() {
        return recipeRepository.findAll();
    }

}
