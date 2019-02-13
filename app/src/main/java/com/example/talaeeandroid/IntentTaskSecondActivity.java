package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.talaeeandroid.content.Constant;
import com.example.talaeeandroid.model.User;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

public class IntentTaskSecondActivity extends AppCompatActivity {

    private TextView tvCountry;
    private TextView tvName;
    private TextView tvFamily;
    private TextView tvAge;
    private TextView tvEmail;
    private TextView tvPhone;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_task_second);
        Hawk.init(IntentTaskSecondActivity.this).build();

        tvCountry = findViewById(R.id.tvCountry);
        tvName = findViewById(R.id.tvName);
        tvFamily = findViewById(R.id.tvFamily);
        tvAge = findViewById(R.id.tvAge);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        int clickedItemIndex = Integer.valueOf(intent.getStringExtra("clickedItemIndex"));

        ArrayList<User> usersInfo = Hawk.get("UsersInfoList");

        tvCountry.setText(usersInfo.get(clickedItemIndex).getCountry());
        tvName.setText(usersInfo.get(clickedItemIndex).getName());
        tvFamily.setText(usersInfo.get(clickedItemIndex).getFamily());
        tvAge.setText(String.valueOf(usersInfo.get(clickedItemIndex).getAge()));
        tvEmail.setText(usersInfo.get(clickedItemIndex).getEmail());
        tvPhone.setText(usersInfo.get(clickedItemIndex).getPhone());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(IntentTaskSecondActivity.this, SharedPreferencesTaskFirstActivity.class);
                startActivity(intentBack);
            }
        });
    }
}
