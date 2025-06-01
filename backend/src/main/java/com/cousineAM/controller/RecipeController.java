package com.cousineAM.controller;

import com.cousineAM.model.Recipe;
import com.cousineAM.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // Get all recipes
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Get a recipe by its unique name
    @GetMapping("/{nome}")
    public ResponseEntity<Recipe> getRecipeByName(@PathVariable String nome) {
        Optional<Recipe> recipe = recipeRepository.findById(nome);
        return recipe.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new recipe
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // Delete a recipe by name
    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String nome) {
        if (recipeRepository.existsById(nome)) {
            recipeRepository.deleteById(nome);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
