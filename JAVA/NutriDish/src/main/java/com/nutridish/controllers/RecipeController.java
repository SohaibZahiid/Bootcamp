package com.nutridish.controllers;

import com.nutridish.entities.RecipeEntity;
import com.nutridish.services.RecipeService;
import com.nutridish.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipes")
    public List<RecipeEntity> getRecipes() {
        return this.recipeService.getRecipes();
    }
}
