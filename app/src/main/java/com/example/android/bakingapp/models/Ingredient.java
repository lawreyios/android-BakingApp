package com.example.android.bakingapp.models;

/**
 * Created by Lawrey on 17/10/17.
 */

public class Ingredient {
    int quantity;
    String measure;
    String ingredient;

    public Ingredient(int quantity, String measure, String ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }
}