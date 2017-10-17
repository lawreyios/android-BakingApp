package com.example.android.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.bakingapp.models.Ingredient;
import com.example.android.bakingapp.models.Recipe;
import com.example.android.bakingapp.models.Step;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecipesRecyclerView;
    private RecipesAdapter mRecipesAdapter;
    private RecyclerView.LayoutManager mRecipesLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipesRecyclerView = (RecyclerView) findViewById(R.id.rv_recipe);
        mRecipesRecyclerView.setHasFixedSize(true);

        mRecipesLayoutManager = new LinearLayoutManager(this);
        mRecipesRecyclerView.setLayoutManager(mRecipesLayoutManager);

        ArrayList<Recipe> test = new ArrayList<>();
        test.add(new Recipe(1, "Test1", new ArrayList<Ingredient>(), new ArrayList<Step>(), 1, ""));
        test.add(new Recipe(1, "Test2", new ArrayList<Ingredient>(), new ArrayList<Step>(), 1, ""));
        test.add(new Recipe(1, "Test3", new ArrayList<Ingredient>(), new ArrayList<Step>(), 1, ""));
        test.add(new Recipe(1, "Test4", new ArrayList<Ingredient>(), new ArrayList<Step>(), 1, ""));

        mRecipesAdapter = new RecipesAdapter(test);
        mRecipesRecyclerView.setAdapter(mRecipesAdapter);

    }
}
