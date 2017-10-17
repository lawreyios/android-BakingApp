package com.example.android.bakingapp.utils;

import com.example.android.bakingapp.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lawrey on 17/10/17.
 */

public interface BakingServiceInterface {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> listRecipes();
}
