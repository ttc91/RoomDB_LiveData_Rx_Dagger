package com.example.roomdb_rxjava_livedata.data.sqlite;

import androidx.room.RoomDatabase;

import com.example.roomdb_rxjava_livedata.data.model.db.Skill;
import com.example.roomdb_rxjava_livedata.data.model.db.User;
import com.example.roomdb_rxjava_livedata.data.sqlite.dao.SkillDAO;
import com.example.roomdb_rxjava_livedata.data.sqlite.dao.UserDAO;

@androidx.room.Database(entities = {User.class, Skill.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract SkillDAO skillDAO();
    public abstract UserDAO userDAO();

}
