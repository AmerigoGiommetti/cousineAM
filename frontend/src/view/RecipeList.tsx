// src/view/RecipeList.tsx

import React, { useEffect, useState } from 'react';
import { fetchRecipes } from '../api/recipes';

interface Recipe {
  name: string;
  season: string;
  course: string;
  info: string;
  meat: boolean;
  fish: boolean;
  eggs: boolean;
  cheese: boolean;
  legumes: boolean;
  carbs: boolean;
  veggies: boolean;
}

const RecipeList: React.FC = () => {
  const [recipes, setRecipes] = useState<Recipe[]>([]);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetchRecipes()
      .then(data => setRecipes(data))
      .catch(err => setError(err.message));
  }, []);

  if (error) {
    return <div>Error: {error}</div>;
  }

  if (recipes.length === 0) {
    return <div>Loading recipes...</div>;
  }

  return (
    <div>
      <h2>Recipes</h2>
      <ul>
        {recipes.map(recipe => (
          <li key={recipe.name}>
            <h3>{recipe.name}</h3>
            <p><strong>Season:</strong> {recipe.season}</p>
            <p><strong>Course:</strong> {recipe.course}</p>
            <p>{recipe.info}</p>
            <p>
              {recipe.meat && 'Meat '}
              {recipe.fish && 'Fish '}
              {recipe.eggs && 'Eggs '}
              {recipe.cheese && 'Cheese '}
              {recipe.legumes && 'Legumes '}
              {recipe.carbs && 'Carbs '}
              {recipe.veggies && 'Veggies '}
            </p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default RecipeList;