package com.example.tarea2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
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

//        editTextTareas = findViewById(R.id.editTextTareas2);
    }

    public void addTodoList(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Agregar Tarea");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String descripcionTarea = input.getText().toString().trim();
                if (!descripcionTarea.isEmpty()) {
                    lista.add(new Tarea(descripcionTarea));
                    listAdapter.notifyDataSetChanged();
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }


}