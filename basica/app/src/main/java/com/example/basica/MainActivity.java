package com.example.basica;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private EditText nacimientoDate;
    private RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, DisplayMessageActivity.class);



        Spinner spinner = (Spinner) findViewById(R.id.spnGenero);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.generos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        nacimientoDate = findViewById(R.id.nacimientoDate);
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        nacimientoDate.setText(day + "/" + (month + 1) + "/" + year);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        nacimientoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("holaaaaaa\n");
                datePickerDialog.show();
            }
        });

    }
    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        int pressed = view.getId();
        // Check which radio button was clicked

         if(pressed == R.id.radio_no){
            if (checked){
                findViewById(R.id.checkBoxJS).setEnabled(false);
                findViewById(R.id.checkBoxJava).setEnabled(false);
                findViewById(R.id.checkBoxGo).setEnabled(false);
                findViewById(R.id.checkBoxCchar).setEnabled(false);
                findViewById(R.id.checkBoxCplus).setEnabled(false);
                findViewById(R.id.checkBoxPython).setEnabled(false);
            }
        }
    }

    public void sendForm(View view){
        //validar form
        boolean valido = false;
        valido = validarForm();
        if (!valido){
            return ;
        }


        // Obtener los datos del formulario
        EditText txtNombre = (EditText) findViewById(R.id.editFieldNombre);
        EditText txtApellido = (EditText) findViewById(R.id.editFieldApellido);
        Spinner spnGenero = (Spinner)findViewById(R.id.spnGenero);
        EditText txtFecha = (EditText) findViewById(R.id.nacimientoDate);
        RadioButton rdbtn = (RadioButton) findViewById(R.id.radio_yes);
        CheckBox java = (CheckBox) findViewById(R.id.checkBoxJava);
        CheckBox python = (CheckBox) findViewById(R.id.checkBoxPython);
        CheckBox go = (CheckBox) findViewById(R.id.checkBoxGo);
        CheckBox js = (CheckBox) findViewById(R.id.checkBoxJS);
        CheckBox cplus = (CheckBox) findViewById(R.id.checkBoxCplus);
        CheckBox cchar = (CheckBox) findViewById(R.id.checkBoxCchar);

        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String genero = spnGenero.getSelectedItem().toString();
        String nacimiento = txtFecha.getText().toString();
        boolean programar = rdbtn.isChecked();

        // Agregar los datos al Intent
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);

        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("genero", genero);
        intent.putExtra("nacimiento", nacimiento);
        intent.putExtra("programar", programar);
        if (java.isChecked()){
            intent.putExtra("java", java.getText().toString());
        }
        if (python.isChecked()){
            intent.putExtra("python", python.getText().toString());
        }
        if (cchar.isChecked()){
            intent.putExtra("cchar", cchar.getText().toString());
        }
        if (go.isChecked()){
            intent.putExtra("go", go.getText().toString());
        }
        if (cplus.isChecked()){
            intent.putExtra("cplus", cplus.getText().toString());
        }
        if (js.isChecked()){
            intent.putExtra("js", js.getText().toString());
        }

        // Iniciar la otra vista
        startActivity(intent);
    }

    private boolean validarForm() {
        boolean valido = true;
        EditText nombre = (EditText) findViewById(R.id.editFieldNombre);
        EditText apellido = (EditText) findViewById(R.id.editFieldApellido);
        EditText nacimiento = (EditText) findViewById(R.id.nacimientoDate);

        if (nombre.getText().toString().isEmpty()){
            nombre.setError("Nombre es requerido");
            valido = false;
        }
        if (apellido.getText().toString().isEmpty()){
            apellido.setError("Apellido es requerido");
            valido = false;
        }
        if (nacimiento.getText().toString().isEmpty()){
            nacimiento.setError("Fecha de nacimiento requerida");
            valido = false;
        }


        return valido;
    }


}