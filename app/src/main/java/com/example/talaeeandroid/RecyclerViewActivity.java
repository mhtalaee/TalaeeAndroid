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

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements UserInfoAdapter.ListItemClickListener {

    RecyclerView recycler;
    Button btnEdit;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Hawk.init(RecyclerViewActivity.this).build();

        List<User> usersInfo = Hawk.get("UsersInfoList");
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
}
