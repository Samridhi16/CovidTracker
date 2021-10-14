package com.example.covid.data;

import com.example.covid.model.User;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User where email=:email and password =:password")
    User getUser(String email, String password);

    @Insert
    void insert(User user);

}
