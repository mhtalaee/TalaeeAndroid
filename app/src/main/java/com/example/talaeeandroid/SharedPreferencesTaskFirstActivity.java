package com.example.talaeeandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.talaeeandroid.content.Constant;
import com.orhanobut.hawk.Hawk;

public class SharedPreferencesTaskFirstActivity extends AppCompatActivity {

    private Button btnEdit;
    private Button btnUsersList;
    private Button btnClearList;
    private Button btnShow;
    private TextView tvTitleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_task_first);
        Hawk.init(SharedPreferencesTaskFirstActivity.this).build();

        btnEdit = findViewById(R.id.btnEdit);
        btnUsersList = findViewById(R.id.btnUsersList);
        btnClearList = findViewById(R.id.btnClearList);
//        btnShow = findViewById(R.id.btnShow);
        tvTitleName = findViewById(R.id.tvTitleName);

        tvTitleName.setText(Hawk.get(Constant.NAME,getString(R.string.guest_user)));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToEditActivity = new Intent(SharedPreferencesTaskFirstActivity.this, IntentTaskFirstActivity.class);
                startActivityForResult(intentToEditActivity, Constant.EDIT_ACTIVITY_REQUEST_CODE);
            }
        });

        btnUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToRecyclerViewActivity = new Intent(SharedPreferencesTaskFirstActivity.this, RecyclerViewActivity.class);
                startActivity(intentToRecyclerViewActivity);
            }
        });

        btnClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hawk.deleteAll();
            }
        });

//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentToShowActivity = new Intent(SharedPreferencesTaskFirstActivity.this, IntentTaskSecondActivity.class);
//                startActivity(intentToShowActivity);
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.EDIT_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(SharedPreferencesTaskFirstActivity.this, R.string.userRefusedData, Toast.LENGTH_LONG).show();
            } else if (resultCode == Activity.RESULT_OK) {
                tvTitleName.setText(data.getStringExtra(Constant.NAME));
                Toast.makeText(SharedPreferencesTaskFirstActivity.this, R.string.userConfirmedData, Toast.LENGTH_LONG).show();
            }
        }
    }
}
