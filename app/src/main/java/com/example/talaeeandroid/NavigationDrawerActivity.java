package com.example.talaeeandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.talaeeandroid.content.Constant;
import com.orhanobut.hawk.Hawk;

public class NavigationDrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Button btnDrawer;
    private Button btnEdit;
    private Button btnUsersList;
    private Button btnClearList;
    private Button btnTimings;
    private Button btnCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        btnDrawer = findViewById(R.id.btnDrawer);
        btnEdit = findViewById(R.id.btnEdit);
        btnUsersList = findViewById(R.id.btnUsersList);
        btnClearList = findViewById(R.id.btnClearList);
        btnTimings = findViewById(R.id.btnTimings);
        btnCamera = findViewById(R.id.btnCamera);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        btnDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
                mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                    }

                    @Override
                    public void onDrawerOpened(@NonNull View drawerView) {
                        Toast.makeText(NavigationDrawerActivity.this, "Drawer Opend!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDrawerClosed(@NonNull View drawerView) {
                        Toast.makeText(NavigationDrawerActivity.this, "Drawer Closed!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {

                    }
                });
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToEditActivity = new Intent(NavigationDrawerActivity.this, IntentTaskFirstActivity.class);
                startActivityForResult(intentToEditActivity, Constant.EDIT_ACTIVITY_REQUEST_CODE);
            }
        });

        btnUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToRecyclerViewActivity = new Intent(NavigationDrawerActivity.this, RecyclerViewActivity.class);
                startActivity(intentToRecyclerViewActivity);
            }
        });

        btnClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hawk.deleteAll();
            }
        });

        btnTimings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToTimingsActivity = new Intent(NavigationDrawerActivity.this, ConnectingToTheInternetAcrivity.class);
                startActivity(intentToTimingsActivity);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToAlertAndPermissionActivity = new Intent(NavigationDrawerActivity.this, AlertDialogAndPermissionActivity.class);
                startActivity(intentToAlertAndPermissionActivity);
            }
        });
    }
}
