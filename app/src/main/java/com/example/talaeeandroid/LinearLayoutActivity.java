package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LinearLayoutActivity extends AppCompatActivity {

    short counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        Log.d("LifeCycle" + counter++, "onCreaet");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle" + counter++, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle" + counter++, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle" + counter++, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle" + counter++, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle" + counter++, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle" + counter++, "onRestart");
    }

}
