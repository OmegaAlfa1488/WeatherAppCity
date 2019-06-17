package com.example.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText user_Name, pass_word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_Name = findViewById(R.id.user_name);
        pass_word = findViewById(R.id.pass_word);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.registration).setOnClickListener(this);

    }
    private void userSignUp() {
        String name = user_Name.getText().toString().trim();
        String pass = pass_word.getText().toString().trim();

        if (name.isEmpty()) {
            user_Name.setError("Enter user name");
            user_Name.requestFocus();
            return;
        }
        if (name.length() < 6) {
            user_Name.setError("Enter user name");
            user_Name.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            user_Name.setError("password is required");
            user_Name.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            user_Name.setError("password should be no less 6 characters");
            user_Name.requestFocus();
            return;
        };

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .createNamePassword(name, pass);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button:
                userSignUp();
                break;

            case R.id.registration:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}

