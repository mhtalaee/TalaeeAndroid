package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.talaeeandroid.content.Constant;
import com.example.talaeeandroid.model.User;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recycler;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Hawk.init(RecyclerViewActivity.this).build();

        List<User> usersInfo = Hawk.get("UsersInfoList");
        recycler = findViewById(R.id.recycler);
        btnEdit = findViewById(R.id.btnEdit);
        UserInfoAdapter userInfoAdapter = new UserInfoAdapter(usersInfo);

        recycler.setAdapter(userInfoAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, RecyclerView.VERTICAL, false));
//        recycler.setLayoutManager(new GridLayoutManager(RecyclerViewActivity.this, 2));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToEditActivity = new Intent(RecyclerViewActivity.this, SharedPreferencesTaskFirstActivity.class);
                startActivity(intentToEditActivity);
            }
        });

    }
}
