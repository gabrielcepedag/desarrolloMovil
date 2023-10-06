package com.example.tarea2.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.tarea2.DAO.TareaDAO;
import com.example.tarea2.Room.TareaRoomDB;
import com.example.tarea2.Tarea;

import java.util.List;

public class TareaRepository {
    private TareaDAO mTareaDao;
    private LiveData<List<Tarea>> mAllTarea;
    public TareaRepository(Application application) {
        TareaRoomDB db = TareaRoomDB.getDatabase(application);
        mTareaDao = db.tareaDAO();
        mAllTarea = mTareaDao.getAllTareas();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Tarea>> getAllWords() {
        return mAllTarea;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Tarea tarea) {
        TareaRoomDB.databaseWriteExecutor.execute(() -> {
            mTareaDao.insert(tarea);
        });
    }
}
