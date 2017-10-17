package com.example.android.bakingapp.models;

import java.util.ArrayList;

/**
 * Created by Lawrey on 17/10/17.
 */

public class Recipe {
    int recipeId;
    String name;
    ArrayList<Ingredient> ingredients;
    ArrayList<Step> steps;
    int servings;
    String image;

    public Recipe(int recipeId, String name, ArrayList<Ingredient> ingredients, ArrayList<Step> steps, int servings, String image) {
        this.recipeId = recipeId;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

    public String getName() {
        return name;
    }
}
