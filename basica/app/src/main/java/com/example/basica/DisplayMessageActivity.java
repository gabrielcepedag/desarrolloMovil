package com.example.basica;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayMessageActivity extends AppCompatActivity {
    private EditText txtViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        String message = "Hola, mi nombre es: ";
        // Obtener los datos del Intent
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String genero = intent.getStringExtra("genero");
        String nacimiento = intent.getStringExtra("nacimiento");
        Boolean programar = intent.getBooleanExtra("programar", true);
        String meGusta = "No me gusta programar.";
        if (programar){
            meGusta = "Me gusta programar. Mis lenguajes favoritos son: ";
            if (intent.getStringExtra("java") != null){
                meGusta+= "Java";
            }
            if (intent.getStringExtra("cchar") != null){
                meGusta+= ", C#";
            }
            if (intent.getStringExtra("python") != null){
                meGusta+= ", python";
            }
            if (intent.getStringExtra("go") != null){
                meGusta+= ", go";
            }
            if (intent.getStringExtra("cplus") != null){
                meGusta+= ", C/C++";
            }
            if (intent.getStringExtra("js") != null){
                meGusta+= ", js";
            }
        }

        message += nombre + apellido + "." + "\n\n" + "Soy "+genero+", y nací en fecha: "+nacimiento+"\n"+meGusta+".";
        TextView resultado = findViewById(R.id.txtViewResultado);
        resultado.setText(message);
    }
}