package com.example.examen;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.example.examen.dto.Producto;

import java.util.ArrayList;
import java.util.List;

public class ItemProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_product2);

        Intent intent = getIntent();
        if (intent != null) {
            List<String> imagenes = new ArrayList<>();
            int id = intent.getIntExtra("id", 0);
            String titulo = intent.getStringExtra("titulo");
            String descripcion = intent.getStringExtra("descripcion");
            imagenes.add(intent.getStringExtra("imagen"));

            Producto producto = new Producto(id, titulo, descripcion, imagenes);

            if (producto != null) {
                TextView tituloTextView = findViewById(R.id.tv_titulo);
                TextView descripcionTextView = findViewById(R.id.tv_descripcion);
                ImageView imagenImageView = findViewById(R.id.iv_imagen);

                tituloTextView.setText(producto.getTitle());
                descripcionTextView.setText(producto.getDescription());

                Glide.with(this).load(producto.getImages().get(0)).into(imagenImageView);
            }
        }
    }
}