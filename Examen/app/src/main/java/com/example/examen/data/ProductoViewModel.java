package com.example.examen.data;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.examen.dto.Producto;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductoViewModel extends AndroidViewModel {

    private ProductoRepo mProductoRepo;
    private final MutableLiveData<List<Producto>> mAllProductos;
    public ProductoViewModel(@NotNull Application application) {
        super(application);
        mProductoRepo = new ProductoRepo(application);
        mAllProductos = mProductoRepo.getAllProductos();
    }

    public MutableLiveData<List<Producto>> getAllProductos() {
        return mAllProductos;
    }

    public Producto getOneProducto(int id){
        return mProductoRepo.getOne(id);
    }

    public void getAllByFilter(String titulo){
        mProductoRepo.getproductosByTitulo(titulo);
    }
}
