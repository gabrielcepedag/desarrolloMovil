package com.example.tarea2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListOrRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_or_recycler_view);

//        Button listViewButton = findViewById(R.id.listViewButton);
        Button recyclerViewButton = findViewById(R.id.recyclerViewButton);

//        listViewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Inicia MainActivity con ListView
//                Intent intent = new Intent(ListOrRecyclerView.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

        recyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia MainActivity con RecyclerView
                Intent intent = new Intent(ListOrRecyclerView.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}