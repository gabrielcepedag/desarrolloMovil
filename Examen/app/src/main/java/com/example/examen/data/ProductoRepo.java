package com.example.examen.data;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.examen.api.APIClient;
import com.example.examen.api.ApiProducto;
import com.example.examen.dto.Producto;
import com.example.examen.dto.ProductoList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ProductoRepo {
    private MutableLiveData<List<Producto>> productosLiveData = new MutableLiveData<>();
    private final ApiProducto apiProducto;

    ProductoRepo(Application application){
        apiProducto = APIClient.getClient().create(ApiProducto.class);

        apiProducto.findAll().enqueue(new Callback<ProductoList>() {
            @Override
            public void onResponse(Call<ProductoList> call, Response<ProductoList> response) {
                Log.w("onResponse", "FUNCIONOOOOOO");
                if (response.isSuccessful()) {
                    ProductoList productoList = response.body();
                    if (productoList != null) {
                        List<Producto> productos = productoList.getProducts();
                        productosLiveData.postValue(productos);
                    }
                }else{
                    Log.e("ERROR", "RESPUESTA API NO FUE 200");
                }
            }

            @Override
            public void onFailure(Call<ProductoList> call, Throwable t) {
                Log.e("ERROR API", t.getMessage());
            }
        });
    }

    public MutableLiveData<List<Producto>> getAllProductos() {
        return productosLiveData;
    }

    public Producto getOne(int id) {
        return (Producto) apiProducto.find(id); //GABRIEL AQUI
    }
}
