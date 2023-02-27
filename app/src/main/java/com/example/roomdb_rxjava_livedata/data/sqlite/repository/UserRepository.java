package com.example.roomdb_rxjava_livedata.data.sqlite.repository;

import com.example.roomdb_rxjava_livedata.data.sqlite.persistence.behavior.UserDataSource;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;

import javax.inject.Inject;

@MyCustomAnnotation.MyQualifier.ApplicationContext
public class UserRepository {

    private final UserDataSource mUserDataSource;

    @Inject
    public UserRepository(UserDataSource mUserDataSource) {
        this.mUserDataSource = mUserDataSource;
    }

    public UserDataSource getMUserDataSource() {
        return mUserDataSource;
    }

}
