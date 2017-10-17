package com.example.android.bakingapp.models;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by Lawrey on 17/10/17.
 */

@Parcel
public class Recipe {
    @SerializedName("id")
    private int recipeId;

    @SerializedName("name")
    private String name;

    @SerializedName("ingredients")
    private ArrayList<Ingredient> ingredients;

    @SerializedName("steps")
    private ArrayList<Step> steps;

    @SerializedName("servings")
    private int servings;

    @SerializedName("image")
    private String image;

    @ParcelConstructor
    public Recipe(int recipeId, String name, ArrayList<Ingredient> ingredients, ArrayList<Step> steps, int servings, String image) {
        this.recipeId = recipeId;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
