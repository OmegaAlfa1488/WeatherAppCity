package com.example.diexpml;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.diexpml.model.DaggerGameComponent;
import com.example.diexpml.model.GameSession;

public class MainActivity extends AppCompatActivity {
    public static final String YOUTUBE_PACKAGE_NAME = "com.google.android.youtube";
    public static final String YOUTUBE_CLASS_NAME = "com.google.android.youtube.WatchActivity";
    GameSession gameSession;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameSession = new GameSession();
        DaggerGameComponent.create().inject(gameSession);
        textView = findViewById(R.id.tv);

    }
    public void click(View view) {
        textView.setText(gameSession.gameData.hello);
        String q = "котёнок";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, q);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
    }
}}