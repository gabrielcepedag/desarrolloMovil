package com.example.tarea2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private EditText editTextTareas;
    private List<Tarea> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lista = new ArrayList<>();
        listAdapter = new ListAdapter(lista, this);
        recyclerView.setAdapter(listAdapter);

        editTextTareas = findViewById(R.id.editTextTareas2);
    }

    public void addTodoList(View v){
        Tarea tarea = new Tarea(editTextTareas.getText().toString());
        if (!tarea.getDescripcion().isEmpty()){
            lista.add(tarea);
            listAdapter.notifyDataSetChanged();
            editTextTareas.setText("");
        }
    }


}