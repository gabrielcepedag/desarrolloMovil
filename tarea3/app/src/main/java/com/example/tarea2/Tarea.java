package com.example.tarea2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarea_table")
public class Tarea {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String descripcion;
    private boolean hecha;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.hecha = false;
    }
    @NonNull
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isHecha() {
        return hecha;
    }

    public void setHecha(boolean hecha) {
        this.hecha = hecha;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
