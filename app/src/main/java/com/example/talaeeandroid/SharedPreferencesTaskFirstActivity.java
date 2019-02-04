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

public class SharedPreferencesTaskFirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_task_first);

        Button btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToEditActivity = new Intent(SharedPreferencesTaskFirstActivity.this, IntentTaskFirstActivity.class);
                startActivityForResult(intentToEditActivity, Constant.EDIT_ACTIVITY_REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvTitleName = findViewById(R.id.tvTitleName);
        if (requestCode == Constant.EDIT_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(SharedPreferencesTaskFirstActivity.this, R.string.userRefusedData, Toast.LENGTH_LONG).show();
            } else if (resultCode == Activity.RESULT_OK) {
                tvTitleName.setText(data.getStringExtra(Constant.NAME));
            }
        }
    }
}
