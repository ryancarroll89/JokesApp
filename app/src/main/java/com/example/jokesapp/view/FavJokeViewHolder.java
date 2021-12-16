package com.example.jokesapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jokesapp.R;

public class FavJokeViewHolder extends RecyclerView.ViewHolder {

    private TextView txtFavJoke;
    private ImageButton ingButtonShare;

    public FavJokeViewHolder(@NonNull View itemView) {
        super(itemView);

        txtFavJoke = itemView.findViewById(R.id.txtFavJoke);
        ingButtonShare = itemView.findViewById(R.id.shareButtonFavListItem);
    }

    public TextView getTxtFavJoke() {
        return txtFavJoke;
    }

    public ImageButton getIngButtonShare() {
        return ingButtonShare;
    }
}
