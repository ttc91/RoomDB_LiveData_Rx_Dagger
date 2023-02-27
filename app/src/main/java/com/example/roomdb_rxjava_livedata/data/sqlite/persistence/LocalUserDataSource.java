package com.example.roomdb_rxjava_livedata.data.sqlite.persistence;

import com.example.roomdb_rxjava_livedata.data.model.db.User;
import com.example.roomdb_rxjava_livedata.data.sqlite.dao.UserDAO;
import com.example.roomdb_rxjava_livedata.data.sqlite.persistence.behavior.UserDataSource;
import com.example.roomdb_rxjava_livedata.data.utils.dagger.custom.MyCustomAnnotation;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@MyCustomAnnotation.MyQualifier.ApplicationContext
public class LocalUserDataSource implements UserDataSource {

    public UserDAO dao;

    @Inject
    public LocalUserDataSource(UserDAO dao){
        this.dao = dao;
    }

    @Override
    public Flowable<User> getFirst() {
        return dao.getFirst();
    }

    @Override
    public Completable insertOrUpdate(User user) {
        return dao.insertOrUpdate(user);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
