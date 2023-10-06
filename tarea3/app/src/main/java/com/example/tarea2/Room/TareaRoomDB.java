package com.example.tarea2.Room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.tarea2.DAO.TareaDAO;
import com.example.tarea2.Tarea;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Tarea.class}, version = 1, exportSchema = false)

public abstract class TareaRoomDB extends RoomDatabase {
    public abstract TareaDAO tareaDAO();
    private static volatile TareaRoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static TareaRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TareaRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TareaRoomDB.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onCreate method to populate the database.
     * For this sample, we clear the database every time it is created.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TareaDAO dao = INSTANCE.tareaDAO();
                dao.deleteAll();

                Tarea tarea = new Tarea("Hello");
                dao.insert(tarea);
                tarea = new Tarea("World");
                dao.insert(tarea);
            });
        }
    };
}
