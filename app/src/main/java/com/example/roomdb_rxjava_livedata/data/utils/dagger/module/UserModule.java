package com.example.roomdb_rxjava_livedata.data.utils.dagger.module;

import com.example.roomdb_rxjava_livedata.data.sqlite.dao.UserDAO;
import com.example.roomdb_rxjava_livedata.data.sqlite.persistence.LocalUserDataSource;
import com.example.roomdb_rxjava_livedata.data.sqlite.persistence.behavior.UserDataSource;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;


import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    @MyCustomAnnotation.MyScope.ActivityScope
    public UserDataSource provideUserDataSource(UserDAO dao){
        return new LocalUserDataSource(dao);
    }

}
