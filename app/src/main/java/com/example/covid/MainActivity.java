package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid.data.UserDAO;
import com.example.covid.data.UserDatabase;
import com.example.covid.model.User;


public class MainActivity extends AppCompatActivity {

    UserDAO db;
    UserDatabase database;

    EditText editEmail,editPassword;
    Button buttonLogin;
    TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editTextEmail);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister =findViewById(R.id.textViewRegister);


        database = Room.databaseBuilder(this,UserDatabase.class,"User")
                .allowMainThreadQueries()
                .build();

        db = database.getUserDao();


        textViewRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString().trim();

                User user = db.getUser(email,password);

                if(user!=null){

                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);

                    intent.putExtra("User",user);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"Unregistered User or Invalid Username/Password",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
