package com.example.talaeeandroid;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.talaeeandroid.content.Constant;
import com.orhanobut.hawk.Hawk;

public class NavigationDrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    //    private Button btnDrawer;
    private Button btnEdit;
    private Button btnUsersList;
    private Button btnClearList;
    private Button btnTimings;
    private Button btnImdb;
    private Button btnCamera;
    private MyBroadcastReceiver receiver;
    private Boolean hasUserClickedOnBack = Boolean.FALSE;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        mDrawerLayout = findViewById(R.id.drawer_layout);
//        btnDrawer = findViewById(R.id.btnDrawer);
        btnEdit = findViewById(R.id.btnEdit);
        btnUsersList = findViewById(R.id.btnUsersList);
        btnClearList = findViewById(R.id.btnClearList);
        btnTimings = findViewById(R.id.btnTimings);
        btnImdb = findViewById(R.id.btnImdb);
        btnCamera = findViewById(R.id.btnCamera);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, intentFilter);

        mToggle = new ActionBarDrawerToggle(NavigationDrawerActivity.this, mDrawerLayout, R.string.lOpen, R.string.lClose);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        btnDrawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDrawerLayout.openDrawer(GravityCompat.START);
//                mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//                    @Override
//                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//                    }
//
//                    @Override
//                    public void onDrawerOpened(@NonNull View drawerView) {
//                        Toast.makeText(NavigationDrawerActivity.this, "Drawer Opend!", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onDrawerClosed(@NonNull View drawerView) {
//                        Toast.makeText(NavigationDrawerActivity.this, "Drawer Closed!", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onDrawerStateChanged(int newState) {
//
//                    }
//                });
//            }
//        });

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

        btnImdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToIMDBActivity = new Intent(NavigationDrawerActivity.this, IMDBActivity.class);
                startActivity(intentToIMDBActivity);
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

    @Override
    public void onBackPressed() {

        if (!hasUserClickedOnBack) {
            Toast.makeText(NavigationDrawerActivity.this, "Please click back again", Toast.LENGTH_SHORT).show();
            hasUserClickedOnBack = Boolean.TRUE;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    hasUserClickedOnBack = Boolean.FALSE;
                }
            }, 2000);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
