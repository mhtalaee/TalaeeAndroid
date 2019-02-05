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
import com.orhanobut.hawk.Hawk;

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

        tvCountry.setText(Hawk.get(Constant.COUNTRY,""));
        tvName.setText(Hawk.get(Constant.NAME,""));
        tvFamily.setText(Hawk.get(Constant.FAMILY,""));
        tvAge.setText(Hawk.get(Constant.AGE,""));
        tvEmail.setText(Hawk.get(Constant.EMAIL,""));
        tvPhone.setText(Hawk.get(Constant.PHONE,""));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(IntentTaskSecondActivity.this, SharedPreferencesTaskFirstActivity.class);
                startActivity(intentBack);
            }
        });
    }
}
