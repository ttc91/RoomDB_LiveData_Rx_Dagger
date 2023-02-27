package com.example.roomdb_rxjava_livedata.data.sqlite.persistence.behavior;

import com.example.roomdb_rxjava_livedata.data.model.db.User;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface UserDataSource {

    Flowable<User> getFirst();

    Completable insertOrUpdate(User user);

    void deleteAll();

}
