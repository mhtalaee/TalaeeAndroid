package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class IntentTaskFirstActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = new String[]{"Belgium", "France", "Italy", "Germany", "Spain", "Iran", "Iraq"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_task_first);

        Button btnOk = findViewById(R.id.btnOk);
        final EditText etName = findViewById(R.id.etName);
        final EditText etFamily = findViewById(R.id.etFamily);
        final EditText etAge = findViewById(R.id.etAge);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPhone = findViewById(R.id.etPhone);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntentTaskFirstActivity.this, IntentTaskSecondActivity.class);
                intent.putExtra(getString(R.string.lName), etName.getText().toString());
                intent.putExtra(getString(R.string.lFamily), etFamily.getText().toString());
                intent.putExtra(getString(R.string.lAge), etAge.getText().toString());
                intent.putExtra(getString(R.string.lEmail), etEmail.getText().toString());
                intent.putExtra(getString(R.string.lNumber), etPhone.getText().toString());
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = findViewById(R.id.countries_list);
        textView.setAdapter(adapter);

    }
}
