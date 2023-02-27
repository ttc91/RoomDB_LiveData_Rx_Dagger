package com.example.roomdb_rxjava_livedata.data.model.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity(tableName = "tbl_skill")
public class Skill implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    public int skillNumber;

    @ColumnInfo(name = "skill_name")
    @NonNull
    public String skillName;

    @ColumnInfo(name = "username")
    @NonNull
    public String username;

}
