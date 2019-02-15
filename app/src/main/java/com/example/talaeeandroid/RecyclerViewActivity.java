package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.talaeeandroid.model.User;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity implements UserInfoAdapter.ListItemClickListener {

    RecyclerView recycler;
    Button btnEdit;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Hawk.init(RecyclerViewActivity.this).build();
        List<User> usersInfo;
        if (Hawk.count() != 0) {
            usersInfo = Hawk.get("UsersInfoList");

        } else {
            usersInfo = generateFakeUsers();
        }

        recycler = findViewById(R.id.recycler);
        btnEdit = findViewById(R.id.btnEdit);
        UserInfoAdapter userInfoAdapter = new UserInfoAdapter(usersInfo, this);

        recycler.setAdapter(userInfoAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, RecyclerView.VERTICAL, false));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentToEditActivity = new Intent(RecyclerViewActivity.this, SharedPreferencesTaskFirstActivity.class);
//                startActivity(intentToEditActivity);
                finish();
            }
        });

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

        Intent intentToShowDetails = new Intent(RecyclerViewActivity.this, IntentTaskSecondActivity.class);
        intentToShowDetails.putExtra("clickedItemIndex", String.valueOf(clickedItemIndex));
        startActivity(intentToShowDetails);
    }

    public List<User> generateFakeUsers() {

        ArrayList<User> usersInfo = new ArrayList<User>();

        for (int i = 0; i < 51; i++) {
            User fakeUser = new User();

            final String[] COUNTRIES = new String[]{"France", "Germany", "Spain", "Iran", "Iraq", "NoCountry"};
            String random = (COUNTRIES[new Random().nextInt(COUNTRIES.length)]);

            fakeUser.setCountry(random);
            fakeUser.setName("Name" + i);
            fakeUser.setFamily("Family" + i);
            fakeUser.setAge(20 + i);
            fakeUser.setEmail("FakeUser" + i + "@gmail.com");
            fakeUser.setPhone("0912123678" + i);
            usersInfo.add(fakeUser);
        }

        return usersInfo;
    }
}
