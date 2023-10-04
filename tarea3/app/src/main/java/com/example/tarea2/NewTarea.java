package com.example.tarea2;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class NewTarea extends AppCompatActivity {
    EditText editText;
    List<Tarea> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tarea);

        editText = findViewById(R.id.editTextAdd);

    }

    public void agregarTarea(View view){

        Intent intent = new Intent(this, RecyclerViewActivity.class);
        String tarea = editText.getText().toString();
        if (!tarea.isEmpty()){
            intent.putExtra("tarea", tarea);
            startActivity(intent);
            editText.setText("");
        }
    }
}