package com.example.roomdb_rxjava_livedata.data.sqlite.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomdb_rxjava_livedata.data.model.db.User;
import com.example.roomdb_rxjava_livedata.data.model.db.relation.UserWithSkill;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM tbl_user LIMIT 1")
    Flowable<User> getFirst();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertOrUpdate(User user);

    @Query("DELETE FROM tbl_user")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM tbl_user")
    List<UserWithSkill> getUserWithSkill();

}
