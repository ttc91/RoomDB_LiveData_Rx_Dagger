package com.example.roomdb_rxjava_livedata.data.model.db.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.roomdb_rxjava_livedata.data.model.db.Skill;
import com.example.roomdb_rxjava_livedata.data.model.db.User;

import java.util.List;

public class UserWithSkill {

    @Embedded
    public User user;

    @Relation(
            parentColumn = "name",
            entityColumn = "username"
    )
    public List<Skill> skills;

}
