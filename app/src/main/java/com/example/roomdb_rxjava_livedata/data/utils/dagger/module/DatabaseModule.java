package com.example.roomdb_rxjava_livedata.data.utils.dagger.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.roomdb_rxjava_livedata.data.sqlite.Database;
import com.example.roomdb_rxjava_livedata.data.sqlite.dao.UserDAO;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private static volatile Database DATABASE;

    private final static String DATABASE_NAME = "user.db";

    public DatabaseModule(Application application){

        if(DATABASE == null){
            Log.e("Database Instance", "NULL");
            synchronized (Database.class){
                DATABASE = Room.databaseBuilder(application,
                        Database.class, DATABASE_NAME).build();
            }
        }else {
            Log.e("Database Instance", "NOT NULL");
        }

    }

    @Provides
    @Singleton
    public UserDAO provideUserDAO(){
        return DATABASE.userDAO();
    }

}
