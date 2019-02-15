package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectingToTheInternetAcrivity extends AppCompatActivity {

    Button btnGetTimes;
    EditText etCityName;
    TextView tvFajr;
    TextView tvSunrise;
    TextView tvDhuhr;
    TextView tvAsr;
    TextView tvSunset;
    TextView tvMaghrib;
    TextView tvIsha;
    TextView tvImsak;
    TextView tvMidnight;
    String timingsByCityURL;
    Button btnBack;

    static final String timingSiteURL = "http://api.aladhan.com/v1/timingsByCity?city=";
    static final String timingSiteFixedVars = "&country=Iran&method=8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connecting_to_the_internet_acrivity);

        btnGetTimes = findViewById(R.id.btnGetTimes);
        etCityName = findViewById(R.id.etCityName);
        tvFajr = findViewById(R.id.tvFajr);
        tvSunrise = findViewById(R.id.tvSunrise);
        tvDhuhr = findViewById(R.id.tvDhuhr);
        tvAsr = findViewById(R.id.tvAsr);
        tvSunset = findViewById(R.id.tvSunset);
        tvMaghrib = findViewById(R.id.tvMaghrib);
        tvIsha = findViewById(R.id.tvIsha);
        tvImsak = findViewById(R.id.tvImsak);
        tvMidnight = findViewById(R.id.tvMidnight);
        btnBack = findViewById(R.id.btnBack);


        btnGetTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {

                            timingsByCityURL = timingSiteURL + etCityName.getText() + timingSiteFixedVars;
                            URL obj = new URL(timingsByCityURL);

                            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                            con.setRequestMethod("GET");
                            con.setRequestProperty("User-Agent", "Mozilla/5.0");

                            int responseCode = con.getResponseCode();

                            if (responseCode == HttpURLConnection.HTTP_OK) {

                                BufferedReader in = new BufferedReader(new InputStreamReader(
                                        con.getInputStream()));

                                String inputLine;
                                StringBuffer response = new StringBuffer();
                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                }


//                                System.out.println(response.toString());
//                                tvResponse.setText(response);
                                JSONObject objResponse = new JSONObject(response.toString());
                                String strData = objResponse.getString("data");
                                JSONObject objData = new JSONObject(strData);
                                String strTimings = objData.getString("timings");
                                JSONObject objTimings = new JSONObject(strTimings);
                                tvFajr.setText(objTimings.getString("Fajr"));
                                tvSunrise.setText(objTimings.getString("Sunrise"));
                                tvDhuhr.setText(objTimings.getString("Dhuhr"));
                                tvAsr.setText(objTimings.getString("Asr"));
                                tvSunset.setText(objTimings.getString("Sunset"));
                                tvMaghrib.setText(objTimings.getString("Maghrib"));
                                tvIsha.setText(objTimings.getString("Isha"));
                                tvImsak.setText(objTimings.getString("Imsak"));
                                tvMidnight.setText(objTimings.getString("Midnight"));
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, "GetTimingByCityThread").start();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
