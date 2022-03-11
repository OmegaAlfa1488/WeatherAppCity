package com.example.weatherappcity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.weatherappcity.R;

public class CityActivity extends AppCompatActivity {
    EditText etSearchCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        etSearchCity = findViewById(R.id.et_search_city);

    }
    public void sendCity(View v){
        String city = etSearchCity.getText().toString();
        Intent data = new Intent();
        data.putExtra(MainActivity.ACCESS_MESSAGE, city);
        setResult(RESULT_OK, data);
        finish();
    }
}