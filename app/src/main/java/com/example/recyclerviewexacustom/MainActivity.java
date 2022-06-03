package com.example.recyclerviewexacustom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recViewM);
        //first step
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //optional
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Data
        String[][] values = {{"1","35","Akhtar"},
                {"2","36","Mukhtiar"},
                {"3","42","Bilal"}};
        RecViewAdapter recViewAdapter = new RecViewAdapter(values);
        recyclerView.setAdapter(recViewAdapter);
    }
}