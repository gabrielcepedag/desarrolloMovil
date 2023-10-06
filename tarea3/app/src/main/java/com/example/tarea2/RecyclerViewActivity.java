package com.example.tarea2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tarea2.Constantes.Accion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TareasViewModel tareasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TaskAdapter taskAdapter =  new TaskAdapter(new TaskAdapter.TaskDiff());
        recyclerView.setAdapter(taskAdapter);

        tareasViewModel = new ViewModelProvider(this).get(TareasViewModel.class);
        tareasViewModel.getTareas().observe(this, tareas -> {
            taskAdapter.submitList(tareas);
        });

        taskAdapter.setTareaConsumer(new BiConsumer<Tarea, Accion>() {
            @Override
            public void accept(Tarea tarea, Accion accion) {
                if (accion == Accion.ELIMINAR){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
                    builder.setTitle("Confirmación de eliminación");
                    builder.setMessage("¿Estás seguro de que deseas eliminar esta tarea?");

                    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tareasViewModel.eliminarTarea(tarea);
                            dialog.dismiss();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if (accion == Accion.COMPLETAR){
                    tareasViewModel.completarTarea(tarea);
                }

            }
        });

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
                    Tarea tarea = new Tarea(descripcionTarea);
                    tareasViewModel.insert(tarea);
                    dialog.dismiss();
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