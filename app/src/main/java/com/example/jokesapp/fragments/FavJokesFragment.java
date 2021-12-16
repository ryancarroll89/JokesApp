package com.example.jokesapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jokesapp.R;
import com.example.jokesapp.controller.FavJokeListAdapter;
import com.example.jokesapp.model.Joke;
import com.example.jokesapp.model.JokeManager;

import java.util.ArrayList;
import java.util.List;

public class FavJokesFragment extends Fragment {

    RecyclerView mRecyclerView;
    FavJokeListAdapter mFavJokeListAdapter;
    JokeManager mJokeManager;
    private List<Joke> mJokeList = new ArrayList<>();

    public FavJokesFragment() {
        // Required empty public constructor
    }

    public static FavJokesFragment newInstance() {
        FavJokesFragment fragment = new FavJokesFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mJokeManager = new JokeManager(context);
        mJokeList.clear();
        if (mJokeManager.retrieveJokes().size() > 0) {
             for (Joke joke : mJokeManager.retrieveJokes()) {
                 mJokeList.add(joke);
             }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav_jokes, container, false);

        if (view != null) {
            mRecyclerView = view.findViewById(R.id.rv);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mFavJokeListAdapter = new FavJokeListAdapter(mJokeList, getContext());
            mRecyclerView.setAdapter(mFavJokeListAdapter);

//            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mSimpleCallback);
//            itemTouchHelper.attachToRecyclerView(mRecyclerView);

        }

        return view;
    }
}