package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.talaeeandroid.model.timings.PrayTimes;
import com.example.talaeeandroid.model.timings.Timings;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class ConnectingToTheInternetAcrivity extends AppCompatActivity {

    Button btnGetTimes;
    EditText etCityName;
    TextView tvDuration;
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
    //    ProgressDialog progress;
    ProgressBar pb;

    static final String timingSiteURL = "http://api.aladhan.com/v1/timingsByCity?city=";
    static final String timingSiteFixedVars = "&country=Iran&method=8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connecting_to_the_internet_acrivity);

        btnGetTimes = findViewById(R.id.btnGetTimes);
        etCityName = findViewById(R.id.etCityName);
        tvDuration = findViewById(R.id.tvDuration);
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
        pb = findViewById(R.id.pbLoading);


        btnGetTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                //Connect to Internet using HttpURLConnection and manual Thread
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        try {
//
//                            timingsByCityURL = timingSiteURL + etCityName.getText() + timingSiteFixedVars;
//                            URL obj = new URL(timingsByCityURL);
//
//                            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//                            con.setRequestMethod("GET");
//                            con.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//                            int responseCode = con.getResponseCode();
//
//                            if (responseCode == HttpURLConnection.HTTP_OK) {
//
//                                BufferedReader in = new BufferedReader(new InputStreamReader(
//                                        con.getInputStream()));
//
//                                String inputLine;
//                                StringBuffer response = new StringBuffer();
//                                while ((inputLine = in.readLine()) != null) {
//                                    response.append(inputLine);
//                                }
//
//
////                                System.out.println(response.toString());
////                                tvResponse.setText(response);
//                                JSONObject objResponse = new JSONObject(response.toString());
//                                String strData = objResponse.getString("data");
//                                JSONObject objData = new JSONObject(strData);
//                                String strTimings = objData.getString("timings");
//                                JSONObject objTimings = new JSONObject(strTimings);
//                                tvFajr.setText(objTimings.getString("Fajr"));
//                                tvSunrise.setText(objTimings.getString("Sunrise"));
//                                tvDhuhr.setText(objTimings.getString("Dhuhr"));
//                                tvAsr.setText(objTimings.getString("Asr"));
//                                tvSunset.setText(objTimings.getString("Sunset"));
//                                tvMaghrib.setText(objTimings.getString("Maghrib"));
//                                tvIsha.setText(objTimings.getString("Isha"));
//                                tvImsak.setText(objTimings.getString("Imsak"));
//                                tvMidnight.setText(objTimings.getString("Midnight"));
//                            }
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, "GetTimingByCityThread").start();

//                progress = new ProgressDialog(ConnectingToTheInternetAcrivity.this);
//                progress.setMessage("Please Wait...");
//                progress.setIndeterminate(false);
//                progress.setCancelable(false);
                AsyncHttpClient client = new AsyncHttpClient();

                timingsByCityURL = timingSiteURL + etCityName.getText() + timingSiteFixedVars;
                client.get(timingsByCityURL, new JsonHttpResponseHandler() {

                    Date startTime;
                    Date finishTime;

                    @Override
                    public void onStart() {
                        startTime = new Date();
//                        progress.show();
                        pb.setVisibility(ProgressBar.VISIBLE);
                        super.onStart();
                    }

                    @Override
                    public void onFinish() {
                        finishTime = new Date();
//                        progress.dismiss();
                        pb.setVisibility(ProgressBar.INVISIBLE);
                        super.onFinish();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        Gson gson = new Gson();
                        PrayTimes prayTimes = gson.fromJson(response.toString(), PrayTimes.class);
                        Timings timings = prayTimes.getData().getTimings();

                        long duration = (finishTime.getTime() - startTime.getTime());

                        tvDuration.setText("Response Duration: " + String.valueOf(duration) + " milliseconds");
                        tvFajr.setText(timings.getFajr());
                        tvSunrise.setText(timings.getSunrise());
                        tvDhuhr.setText(timings.getDhuhr());
                        tvAsr.setText(timings.getAsr());
                        tvSunset.setText(timings.getSunset());
                        tvMaghrib.setText(timings.getMaghrib());
                        tvIsha.setText(timings.getIsha());
                        tvImsak.setText(timings.getImsak());
                        tvMidnight.setText(timings.getMidnight());

                        super.onSuccess(statusCode, headers, response);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }

                });

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
