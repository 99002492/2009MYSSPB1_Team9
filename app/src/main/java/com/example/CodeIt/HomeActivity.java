package com.example.CodeIt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recylerView;

    String s1[], s2[];
    int images[]={R.drawable.c,R.drawable.cpp,R.drawable.csharp,R.drawable.java,R.drawable.js,R.drawable.kotlin,R.drawable.python,R.drawable.ruby,R.drawable.swift,R.drawable.ts};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recylerView = findViewById(R.id.recylerView);

        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recylerView.setAdapter(myAdapter);
        recylerView.setLayoutManager(new LinearLayoutManager(this));
    }
}