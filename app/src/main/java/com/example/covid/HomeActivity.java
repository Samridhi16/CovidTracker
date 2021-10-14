package com.example.covid;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covid.model.User;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUser;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user = (User) getIntent().getSerializableExtra("User");
        tvUser = findViewById(R.id.tvUser);

        if (user != null) {
            tvUser.setText("WELCOME " + user.getUserName());
        }


        RecyclerView List = (RecyclerView)findViewById(R.id.recyclerView);
        List.setLayoutManager(new LinearLayoutManager(this));

        String []titles ={"India : Statistics","Help Gov with the Survey","Get Passes Issued"};

        List.setAdapter(new ProgrammingAdapter(titles));

    }
}
