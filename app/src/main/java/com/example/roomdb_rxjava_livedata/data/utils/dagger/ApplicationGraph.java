package com.example.roomdb_rxjava_livedata.data.utils.dagger;

import com.example.roomdb_rxjava_livedata.data.utils.MyApplication;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.component.sub.UserComponent;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.module.ApplicationModule;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.module.DatabaseModule;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.module.SubComponentModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {SubComponentModule.class, ApplicationModule.class, DatabaseModule.class})
@Singleton
public interface ApplicationGraph {

    UserComponent.Factory mUserComponent();

    void inject(MyApplication application);

}
