package com.example.talaeeandroid;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.talaeeandroid.model.imdb.ImdbMovie;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class IMDBActivity extends AppCompatActivity {

    Button btnGetMovieInfo;
    EditText etMovieName;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDirector;
    TextView tvWriter;
    TextView tvActors;
    TextView tvCountry;
    TextView tvAwards;
    String timingsByCityURL;
    Button btnBack;
    ImageView imgMoviePoster;
    //    ProgressDialog progress;
    ProgressBar pb;

    static final String timingSiteURL = "http://www.omdbapi.com/?t=";
    static final String timingSiteFixedVars = "&apikey=70ad462a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imdb);

        btnGetMovieInfo = findViewById(R.id.btnGetMovieInfo);
        etMovieName = findViewById(R.id.etMovieName);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvGenre = findViewById(R.id.tvGenre);
        tvDirector = findViewById(R.id.tvDirector);
        tvWriter = findViewById(R.id.tvWriter);
        tvActors = findViewById(R.id.tvActors);
        tvCountry = findViewById(R.id.tvCountry);
        tvAwards = findViewById(R.id.tvAwards);
        btnBack = findViewById(R.id.btnBack);
        pb = findViewById(R.id.pbLoading);
        imgMoviePoster = findViewById(R.id.imgMoviePoster);

        btnGetMovieInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AsyncHttpClient client = new AsyncHttpClient();

                timingsByCityURL = timingSiteURL + etMovieName.getText() + timingSiteFixedVars;
                client.get(timingsByCityURL, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        pb.setVisibility(ProgressBar.VISIBLE);
                        super.onStart();
                    }

                    @Override
                    public void onFinish() {
                        pb.setVisibility(ProgressBar.INVISIBLE);
                        super.onFinish();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        Gson gson = new Gson();
                        ImdbMovie imdbMovie = gson.fromJson(response.toString(), ImdbMovie.class);

                        tvTitle.setText(imdbMovie.getTitle());
                        tvYear.setText(imdbMovie.getYear());
                        tvGenre.setText(imdbMovie.getGenre());
                        tvDirector.setText(imdbMovie.getDirector());
                        tvWriter.setText(imdbMovie.getWriter());
                        tvActors.setText(imdbMovie.getActors());
                        tvCountry.setText(imdbMovie.getCountry());
                        tvAwards.setText(imdbMovie.getAwards());
                        Picasso.get().load(imdbMovie.getPoster()).into(imgMoviePoster);

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
