package com.example.mytest.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mytest.Api;
import com.example.mytest.R;
import com.example.mytest.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private EditText user_Name, pass_word;
        private Api api;

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
        }
        User user = new User(name, pass);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
        sendRequest(user);
    }

    private void sendRequest(User user) {
        Call<User> call = api.createAccount(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                }
                   User userResponse = response.body();
                   Toast.makeText(MainActivity.this,"{Success: " + userResponse.isSuccess() +
                       "\n" + "token: " + userResponse.getToken() + "}", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                  Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button:
                userSignUp();
                break;

            case R.id.registration:
                 startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}

