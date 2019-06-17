package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editName;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.edit_name);
        editPassword = findViewById(R.id.edit_password);


        findViewById(R.id.button_login).setOnClickListener(this);
        findViewById(R.id.view_login).setOnClickListener(this);
    }
    private void userLogin(){
String username = editName.getText().toString().trim();
String password = editPassword.getText().toString().trim();


        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi().userLogin(username,password);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();//error 500
                        if(!loginResponse.isSuccess()){
                            Toast.makeText( LoginActivity.this,"" , Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginActivity.this, "Fine", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                userLogin();
                break;
            case R.id.view_login:
                break;
        }
    }
}
