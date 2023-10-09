package com.example.examen.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductoList implements Serializable {
    private List<Producto> products = new ArrayList<>();
    private Integer total;
    private Integer skip;
    private Integer limit;
    public List<Producto> getProducts() {
        return products;
    }
    public void setProducts(List<Producto> products) {
        this.products = products;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public Integer getSkip() {
        return skip;
    }
    public void setSkip(Integer skip) {
        this.skip = skip;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
