package com.example.mytest.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mytest.Api;
import com.example.mytest.R;
import com.example.mytest.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editName;
    private EditText editPassword;
    Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.edit_name);
        editPassword = findViewById(R.id.edit_password);


        findViewById(R.id.button_login).setOnClickListener(this);
        findViewById(R.id.view_login).setOnClickListener(this);
    }
    private void enterShop(){
        startActivity(new Intent(this, ProductsActivity.class));

    }private void outToMain(){
        startActivity(new Intent(this, MainActivity.class));
    }
    private void userLogin(){
        String username = editName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        User user = new User(username, password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
        Call<User> call = api.userLogin(user);
                call.enqueue(new Callback<User>() {
                    @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                        User userResponse = response.body();
                        if(!response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                        }else if(userResponse.getToken() != null & userResponse.isSuccess()) {
                            Toast.makeText(LoginActivity.this,"{Success: " + userResponse.isSuccess() +
                                    "\n" + "token: " + userResponse.getToken() + "}", Toast.LENGTH_SHORT).show();
                            enterShop();
                        }
                        else if(userResponse.getToken() == null & userResponse.isSuccess() == false) {
                            Toast.makeText(LoginActivity.this, "You didn't Sign In", Toast.LENGTH_SHORT).show();
                            outToMain();
                        }
                        else {
                            outToMain();
                            Toast.makeText(LoginActivity.this, "User not found or password mismatch", Toast.LENGTH_SHORT).show();
                        }
                        }
                     @Override
                    public void onFailure(Call<User> call, Throwable t) {
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
