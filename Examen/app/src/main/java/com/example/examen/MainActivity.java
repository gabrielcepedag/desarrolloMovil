package com.example.examen;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen.adapter.ProductoAdapter;
import com.example.examen.data.ProductoViewModel;
import com.example.examen.dto.Producto;

import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductoViewModel productoViewModel;
    private EditText editText;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_search);
        btnBuscar = findViewById(R.id.btn_search);

        recyclerView = findViewById(R.id.rv_products);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductoAdapter productoAdapter =  new ProductoAdapter(new ProductoAdapter.ProductoDiff());
        recyclerView.setAdapter(productoAdapter);

        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        productoViewModel.getAllProductos().observe(this, productos -> {
            productoAdapter.submitList(productos);
        });

        productoAdapter.setProductoConsumer(new Consumer<Producto>() {
            @Override
            public void accept(Producto producto) {
                Intent intent = new Intent(MainActivity.this, ItemProductActivity.class);
                intent.putExtra("id", producto.getId());
                intent.putExtra("titulo", producto.getTitle());
                intent.putExtra("descripcion", producto.getDescription());
                intent.putExtra("imagen", producto.getImages().get(0));
                startActivity(intent);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productoViewModel.getAllByFilter(editText.getText().toString());

            }
        });
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
    }
}