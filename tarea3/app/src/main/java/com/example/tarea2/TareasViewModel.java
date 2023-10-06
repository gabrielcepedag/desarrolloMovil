package com.example.tarea2;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.tarea2.repository.TareaRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TareasViewModel extends AndroidViewModel {
    private TareaRepository tareaRepository;
    private final LiveData<List<Tarea>> mAllTareas;

    public TareasViewModel(@NotNull Application application) {
        super(application);
        tareaRepository = new TareaRepository(application);
        mAllTareas = tareaRepository.getAllWords();
    }

    public LiveData<List<Tarea>> getTareas() {
        return mAllTareas;
    }

    public void insert(Tarea tarea){
        tareaRepository.insert(tarea);
    }

//    public void setTareas(LiveData<List<Tarea>> tareas) {
//        Log.w("klk", "que mmg");
////        this.tareas = tareas;
//
//    }

//    public void addTarea(String tarea){
//        Tarea tarea1 = new Tarea(tarea);
//        tareas.getValue().add(tarea1);
//    }

//    public void completar(Tarea tarea){
//        tarea.setHecha(true);
//    }
}
