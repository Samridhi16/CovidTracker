package com.example.covid;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsername,editTestEmail,editTestPassword,editTestCnfPassword;
    TextView textViewLogin;
    Button buttonRegister;

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTestEmail = findViewById(R.id.editTextEmail);
        editTestPassword = findViewById(R.id.editTextPassword);
        editTestCnfPassword = findViewById(R.id.editTextCnfPassword);

        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        userDAO = Room.databaseBuilder(this, UserDatabase.class,"User").allowMainThreadQueries().build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = editTextUsername.getText().toString();
                String email = editTestEmail.getText().toString().trim();
                String password = editTestPassword.getText().toString().trim();
                String passwordConf = editTestCnfPassword.getText().toString().trim();


                if(password.equals(passwordConf)){

                    User user = new User(userName,email,password);
                    userDAO.insert(user);

                    Intent moveToLogin = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(moveToLogin);
                }else{

                    Toast.makeText(RegisterActivity.this,"Password not matching",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
