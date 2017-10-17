package com.example.android.bakingapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.bakingapp.models.Ingredient;
import com.example.android.bakingapp.models.Recipe;
import com.example.android.bakingapp.models.Step;
import com.example.android.bakingapp.utils.BakingServiceClient;
import com.example.android.bakingapp.utils.BakingServiceInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecipesRecyclerView;
    private RecipesAdapter mRecipesAdapter;
    private RecyclerView.LayoutManager mRecipesLayoutManager;
    private ProgressBar mProgressBar;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipesRecyclerView = (RecyclerView) findViewById(R.id.rv_recipe);
        mRecipesRecyclerView.setHasFixedSize(true);

        mRecipesLayoutManager = new LinearLayoutManager(this);
        mRecipesRecyclerView.setLayoutManager(mRecipesLayoutManager);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        mProgressBar.setVisibility(View.VISIBLE);

        BakingServiceInterface bakingService = BakingServiceClient.getClient().create(BakingServiceInterface.class);
        Call<List<Recipe>> call = bakingService.listRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                ArrayList<Recipe> recipes = (ArrayList<Recipe>) response.body();
                Log.d(TAG, "Number of recipes received: " + recipes.size());

                mRecipesAdapter = new RecipesAdapter(recipes);
                mRecipesRecyclerView.setAdapter(mRecipesAdapter);

                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e(TAG, t.toString());
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}
