package com.example.android.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bakingapp.models.Recipe;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by Lawrey on 17/10/17.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {
    private ArrayList<Recipe> mRecipesData;

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView titleTextView;
        ImageView mainImage;

        RecipeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_recipe);
            titleTextView = (TextView) itemView.findViewById(R.id.tv_recipe_title);
            mainImage = (ImageView) itemView.findViewById(R.id.iv_recipe);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;

            Recipe selectedRecipe = mRecipesData.get(getAdapterPosition());

            intent = new Intent(view.getContext(), RecipeDetailsActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("Recipe", Parcels.wrap(selectedRecipe));

            Parcelable wrapped = Parcels.wrap(selectedRecipe);
            intent.putExtra("Recipe", wrapped);

            view.getContext().startActivity(intent);
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

    public void setData(ArrayList<Recipe> data) {
        mRecipesData = data;
    }
}
