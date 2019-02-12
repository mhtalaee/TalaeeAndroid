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
import com.example.talaeeandroid.model.User;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

public class IntentTaskFirstActivity extends AppCompatActivity {

    private AutoCompleteTextView etCountry;
    private EditText etName;
    private EditText etFamily;
    private EditText etAge;
    private EditText etEmail;
    private EditText etPhone;

    private ArrayList<User> usersInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_task_first);
        Hawk.init(IntentTaskFirstActivity.this).build();

        etCountry = findViewById(R.id.etCountry);
        etName = findViewById(R.id.etName);
        etFamily = findViewById(R.id.etFamily);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        Button btnOk = findViewById(R.id.btnOk);
        Button btnCancel = findViewById(R.id.btnCancel);

        initiateCountryList();
//        initiateForm();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Hawk.put(Constant.COUNTRY, etCountry.getText().toString());
//                Hawk.put(Constant.NAME, etName.getText().toString());
//                Hawk.put(Constant.FAMILY, etFamily.getText().toString());
//                Hawk.put(Constant.AGE, etAge.getText().toString());
//                Hawk.put(Constant.EMAIL, etEmail.getText().toString());
//                Hawk.put(Constant.PHONE, etPhone.getText().toString());



                User user = new User();
                user.setCountry(etCountry.getText().toString());
                user.setName(etName.getText().toString());
                user.setFamily(etFamily.getText().toString());
                user.setAge(Integer.valueOf(etAge.getText().toString()));
                user.setEmail(etEmail.getText().toString());
                user.setPhone(etPhone.getText().toString());
                usersInfo = (Hawk.contains("UsersInfoList")) ? usersInfo = Hawk.get("UsersInfoList") : new ArrayList<User>();
                usersInfo.add(user);
                Hawk.put("UsersInfoList",usersInfo);

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

    private void initiateCountryList() {
        final String[] COUNTRIES = new String[]{"France", "Germany", "Spain", "Iran", "Iraq"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        etCountry.setAdapter(adapter);
    }

    private void initiateForm() {
        Hawk.init(IntentTaskFirstActivity.this).build();
        etCountry.setText(Hawk.get(Constant.COUNTRY,"").toString());
        etName.setText(Hawk.get(Constant.NAME,"").toString());
        etFamily.setText(Hawk.get(Constant.FAMILY,"").toString());
        etAge.setText(Hawk.get(Constant.AGE,"").toString());
        etEmail.setText(Hawk.get(Constant.EMAIL,"").toString());
        etPhone.setText(Hawk.get(Constant.PHONE,"").toString());
    }

}
