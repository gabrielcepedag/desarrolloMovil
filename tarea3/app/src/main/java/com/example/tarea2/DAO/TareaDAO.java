package com.example.tarea2.DAO;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.*;
import com.example.tarea2.Tarea;

import java.util.List;

@Dao
public interface TareaDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Tarea tarea);
    @Query("DELETE FROM tarea_table")
    void deleteAll();
    @Query("SELECT * FROM tarea_table")
    LiveData<List<Tarea>> getAllTareas();
    @Delete
    void delete(Tarea tarea);
    @Update
    void update(Tarea tarea);
}
