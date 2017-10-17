package com.example.android.bakingapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.bakingapp.models.Recipe;

import java.util.ArrayList;

/**
 * Created by Lawrey on 17/10/17.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {
    private ArrayList<Recipe> mRecipesData;

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView titleTextView;
        ImageView mainImage;

        RecipeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_recipe);
            titleTextView = (TextView) itemView.findViewById(R.id.tv_recipe_title);
            mainImage = (ImageView) itemView.findViewById(R.id.iv_recipe);
        }
    }

    public RecipesAdapter(ArrayList<Recipe> data) {
        mRecipesData = data;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card_item, parent, false);
        RecipeViewHolder rvh = new RecipeViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.titleTextView.setText(mRecipesData.get(position).getName());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mRecipesData.size();
    }
}
