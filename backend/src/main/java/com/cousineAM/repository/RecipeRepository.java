package com.cousineAM.repository;

import com.cousineAM.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, String> {
    // Puoi aggiungere query personalizzate qui, se vuoi (es. findByStagione, etc.)
}
