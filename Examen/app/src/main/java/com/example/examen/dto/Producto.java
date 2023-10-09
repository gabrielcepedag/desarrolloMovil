package com.example.examen.dto;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private Integer id;
    private String title;
    private String description;
    private List<String> images = new ArrayList<String>();

    public Producto(Integer id, String title, String description, List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {
        return images;
    }
}
