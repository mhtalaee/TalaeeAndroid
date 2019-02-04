package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.talaeeandroid.content.Constant;

public class IntentTaskFirstActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = new String[]{"Belgium", "France", "Italy", "Germany", "Spain", "Iran", "Iraq"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_task_first);

        final EditText etName = findViewById(R.id.etName);
        final EditText etFamily = findViewById(R.id.etFamily);
        final EditText etAge = findViewById(R.id.etAge);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPhone = findViewById(R.id.etPhone);
        final AutoCompleteTextView etCountry = findViewById(R.id.etCountry);
        Button btnOk = findViewById(R.id.btnOk);
        Button btnCancel = findViewById(R.id.btnCancel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = findViewById(R.id.etCountry);
        textView.setAdapter(adapter);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(IntentTaskFirstActivity.this, IntentTaskSecondActivity.class);
//                intent.putExtra(Constant.EXTRA_COUNTRY, etCountry.getText().toString());
//                intent.putExtra(Constant.EXTRA_NAME, etName.getText().toString());
//                intent.putExtra(Constant.EXTRA_FAMILY, etFamily.getText().toString());
//                intent.putExtra(Constant.EXTRA_AGE, etAge.getText().toString());
//                intent.putExtra(Constant.EXTRA_EMAIL, etEmail.getText().toString());
//                intent.putExtra(Constant.EXTRA_PHONE, etPhone.getText().toString());
//                startActivity(intent);

                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(IntentTaskFirstActivity.this);
                sp.edit().putString(Constant.COUNTRY, etCountry.getText().toString()).apply();
                sp.edit().putString(Constant.NAME, etName.getText().toString()).apply();
                sp.edit().putString(Constant.FAMILY, etFamily.getText().toString()).apply();
                sp.edit().putString(Constant.AGE, etAge.getText().toString()).apply();
                sp.edit().putString(Constant.EMAIL, etEmail.getText().toString()).apply();
                sp.edit().putString(Constant.PHONE, etPhone.getText().toString()).apply();

                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constant.NAME, etName.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });


    }
}
