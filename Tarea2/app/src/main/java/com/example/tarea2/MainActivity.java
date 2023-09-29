package com.example.tarea2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.*;
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

        setupListViewListener();
    }

    public void addTodoToList(View view){

        lista.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }

//     Attaches a long click listener to the listview
    private void setupListViewListener() {
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        AlertDialog.Builder modal = new AlertDialog.Builder(MainActivity.this);
                        modal.setTitle("Confirmación");
                        modal.setMessage("Estás seguro de que deseas eliminar esta tarea?");
                        modal.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                lista.remove(pos);
                                arrayAdapter.notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });
                        modal.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        modal.show();
                        return true;
                    }

                });
    }
}