package com.example.roomdb_rxjava_livedata.data.model.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

@Entity(tableName = "tbl_user")
public class User implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "name")
    @NonNull
    public String name;


    @ColumnInfo(name = "age")
    @NonNull
    public int age;

    @NonNull
    @ColumnInfo(name = "professional")
    public String professional;

}
