package com.example.tarea2;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TareasViewModel extends AndroidViewModel {
    private final LiveData<List<Tarea>> tareas;

    public TareasViewModel(@NotNull Application application, LiveData<List<Tarea>> tareas) {
        super(application);
        this.tareas = tareas;
    }

    public LiveData<List<Tarea>> getTareas() {
        return tareas;
//        return tareas;
    }

//    public void setTareas(LiveData<List<Tarea>> tareas) {
//        Log.w("klk", "que mmg");
////        this.tareas = tareas;
//
//    }

    public void addTarea(String tarea){
        Tarea tarea1 = new Tarea(tarea);
        tareas.getValue().add(tarea1);
    }

//    public void completar(Tarea tarea){
//        tarea.setHecha(true);
//    }
}
