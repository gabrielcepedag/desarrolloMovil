package com.example.tarea2;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    List<String> lista;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();
        lista.add("Hola mundo");
        arrayAdapter = new ArrayAdapter<>(this, R.layout.todolist_view_layout, lista);
        listView = findViewById(R.id.todo_list_view);

        listView.setAdapter(arrayAdapter);

        editText = findViewById(R.id.editTextTareas);
    }

    public void addTodoToList(View view){

        lista.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }
}