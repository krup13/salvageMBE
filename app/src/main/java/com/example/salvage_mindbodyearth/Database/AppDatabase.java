package com.example.salvage_mindbodyearth.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {}, version = 1)
public abstract class AppDatabase {

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, DbConfig.ROOM_DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}