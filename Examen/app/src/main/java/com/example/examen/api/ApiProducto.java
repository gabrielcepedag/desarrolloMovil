package com.example.examen.api;

import com.example.examen.dto.Producto;
import com.example.examen.dto.ProductoList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiProducto {
    @GET("products")
    Call<ProductoList> findAll();

    @GET("products/{id}")
    Call<Producto> find(@Path("id") int id);
}
