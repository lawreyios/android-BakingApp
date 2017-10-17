package com.example.android.bakingapp;

import android.app.ActionBar;
import android.os.Parcel;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.bakingapp.models.Recipe;

import org.parceler.Parcels;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Recipe recipe = Parcels.unwrap(getIntent().getParcelableExtra("Recipe"));

        setTitle(recipe.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
