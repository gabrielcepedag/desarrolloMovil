package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen.adapter.ProductoAdapter;
import com.example.examen.api.APIClient;
import com.example.examen.api.ApiProducto;
import com.example.examen.dto.Producto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_products);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductoAdapter productoAdapter =  new ProductoAdapter(new ProductoAdapter.ProductoDiff());
        recyclerView.setAdapter(productoAdapter);

//        List<Producto> prueba = new ArrayList<>();
//        prueba.add(new Producto(1, "TITULO DE PRUEBA", "HOLA SIY UNA PAKJSAJS ALSJALSK LKASMAS AKSMASMLAS MAKLSAKLAKNSAkdnsfsdkf", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//        prueba.add(new Producto(2, "TITULO DE PRUEBA 2", "22222222HOLA SIY UNA PAKJSAJS ALSJALSK LKASMA", new ArrayList<>()));
//
//        productoAdapter.submitList(prueba);

        ApiProducto api = APIClient.getClient().create(ApiProducto.class);
    }
}