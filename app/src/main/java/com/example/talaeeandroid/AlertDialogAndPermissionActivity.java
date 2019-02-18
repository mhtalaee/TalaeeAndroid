package com.example.talaeeandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogAndPermissionActivity extends AppCompatActivity {

    private Button btnOpenCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_and_permission);

        btnOpenCamera = findViewById(R.id.btnOpenCamera);

        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AlertDialogAndPermissionActivity.this);

                alertDialogBuilder.setTitle("Open Camera");
                alertDialogBuilder.setMessage("Allow app to access your camera?");
                alertDialogBuilder.setIcon(R.drawable.camera);
                alertDialogBuilder.setCancelable(Boolean.FALSE);
                alertDialogBuilder.setPositiveButton(getString(R.string.lYes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialogBuilder.setNegativeButton(R.string.lNo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();
            }
        });
    }
}
