package com.example.covid.data;

import com.example.covid.data.UserDAO;
import com.example.covid.model.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public  abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO getUserDao();

}
