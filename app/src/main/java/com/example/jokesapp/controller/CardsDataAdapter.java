package com.example.jokesapp.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.jokesapp.R;
import com.example.jokesapp.model.Joke;

public class CardsDataAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private boolean clicked = true;

    private JokeLikeListener  mJokeLikeListener;
    private Joke mJoke;

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        mContext = context;

        mJokeLikeListener = (JokeLikeListener) context;
    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent){
        //supply the layout for your card
        TextView v = (contentView.findViewById(R.id.content));
        v.setText(getItem(position));

        ImageButton likeButton = contentView.findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, "The Like button is tapped", Toast.LENGTH_SHORT).show();
                if (clicked) {
                    likeButton.setImageResource(R.drawable.like_filled);
                    clicked = false;

                    mJoke = new Joke(getItem(position), true);
                }
                else {
                    likeButton.setImageResource(R.drawable.like_empty);
                    clicked = true;

                    mJoke = new Joke(getItem(position), false);
                }
                mJokeLikeListener.jokeIsLiked(mJoke);
            }
        });

        ImageButton shareButton = contentView.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Create an ACTION_SEND Intent*/
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = v.getText().toString();
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Mama Joke!");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                /*Fire!*/
                v.getContext().startActivity(Intent.createChooser(intent, "Share Via"));

            }
        });

        return contentView;
    }

}

