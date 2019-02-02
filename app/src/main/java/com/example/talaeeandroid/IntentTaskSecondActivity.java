package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntentTaskSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_task_second);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvFamily = findViewById(R.id.tvFamily);
        TextView tvAge = findViewById(R.id.tvAge);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPhone = findViewById(R.id.tvPhone);
        Button btnConfirm = findViewById(R.id.btnConfirm);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra(getString(R.string.lName)));
        tvFamily.setText(intent.getStringExtra(getString(R.string.lFamily)));
        tvAge.setText(intent.getStringExtra(getString(R.string.lAge)));
        tvEmail.setText(intent.getStringExtra(getString(R.string.lEmail)));
        tvPhone.setText(intent.getStringExtra(getString(R.string.lNumber)));

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IntentTaskSecondActivity.this, R.string.msgSuccessfullSave, Toast.LENGTH_LONG).show();
            }
        });


    }
}
