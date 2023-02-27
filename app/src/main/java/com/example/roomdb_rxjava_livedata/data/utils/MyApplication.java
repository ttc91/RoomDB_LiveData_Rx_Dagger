package com.example.roomdb_rxjava_livedata.data.utils;

import android.app.Application;

import com.example.roomdb_rxjava_livedata.data.utils.dagger.ApplicationGraph;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.DaggerApplicationGraph;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.component.provider.UserComponentProvider;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.component.sub.UserComponent;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.module.ApplicationModule;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.module.DatabaseModule;

public class MyApplication extends Application implements UserComponentProvider{

    private ApplicationGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        graph = DaggerApplicationGraph.builder()
                .applicationModule(new ApplicationModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
        graph.inject(this);
    }

    @Override
    public UserComponent provideUserComponent() {
        return graph.mUserComponent().create();
    }

}
