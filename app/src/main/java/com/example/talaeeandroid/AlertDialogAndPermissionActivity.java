package com.example.talaeeandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

                if (ContextCompat.checkSelfPermission(AlertDialogAndPermissionActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AlertDialogAndPermissionActivity.this);
                    alertDialogBuilder.setTitle("Open Camera");
                    alertDialogBuilder.setMessage("Allow app to access your camera?");
                    alertDialogBuilder.setIcon(R.drawable.camera);
                    alertDialogBuilder.setCancelable(Boolean.FALSE);
                    alertDialogBuilder.setPositiveButton(getString(R.string.lYes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(AlertDialogAndPermissionActivity.this, new String[]{Manifest.permission.CAMERA},
                                    100);
                        }
                    });

                    alertDialogBuilder.setNegativeButton(R.string.lNo, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogAndPermissionActivity.this, "User denied camera permission", Toast.LENGTH_LONG).show();
                        }
                    });

                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();

                } else {
                    Toast.makeText(AlertDialogAndPermissionActivity.this, "Camer permission allready granted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
