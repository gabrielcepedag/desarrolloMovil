package com.example.tarea2;

public class Tarea {
    private String descripcion;
    private boolean hecha;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.hecha = false;
    }

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
}
