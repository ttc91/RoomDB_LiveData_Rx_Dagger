package com.example.roomdb_rxjava_livedata.data.utils.dagger.module;

import android.content.Context;

import com.example.roomdb_rxjava_livedata.data.utils.MyApplication;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    MyApplication myApplication;

    public ApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    @MyCustomAnnotation.MyQualifier.ApplicationContext
    public Context provideApplicationContext(){
        return myApplication;
    }

}
