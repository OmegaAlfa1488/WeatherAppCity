package com.example.mytest.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mytest.ApiComment;
import com.example.mytest.CommentSend;
import com.example.mytest.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText rating, comment;
    ApiComment apiComment;
    String id;
   // User user;
    //String token = user.getToken();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);
        rating = findViewById(R.id.editTextRating);
        comment = findViewById(R.id.editTextComment);
        findViewById(R.id.buttonSend).setOnClickListener(this);
        Intent intent = getIntent();
        id = intent.getStringExtra("idProduct");
    }
private void sendComment(){
    String rate = rating.getText().toString().trim();
    String text = comment.getText().toString().trim();
    if (rate.isEmpty()) {
        rating.setError("Enter your mark");
        rating.requestFocus();
        return;
    }
    if (rate.length() > 1) {
        rating.setError("Enter user mark");
        rating.requestFocus();
        return;
    }
    if (text.isEmpty()) {
        comment.setError("enter your text");
        comment.requestFocus();
        return;
    }
    if (text.length() < 10) {
        comment.setError("Your text should be more than 10 characters");
        comment.requestFocus();
        return;
    }
    CommentSend commentSend = new CommentSend(rate,text);
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiComment.URL_DATA_COMMENT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    apiComment = retrofit.create(ApiComment.class);
    sendComment(commentSend);
}
private void sendComment(CommentSend commentSend){
    Call<CommentSend> call = apiComment.sendComment(/*token,*/commentSend);
   call.enqueue(new Callback<CommentSend>() {
        @Override
        public void onResponse(Call<CommentSend> call, Response<CommentSend> response) {
            if (!response.isSuccessful()) { //I am so sorry for this thing :) I REALIZED IT TOO LATE...
                Toast.makeText(CommentActivity.this, "Success :)" , Toast.LENGTH_SHORT).show();
            }
            CommentSend commentResponse = response.body();
            Toast.makeText(CommentActivity.this, "", Toast.LENGTH_SHORT).show();
            }

        @Override
        public void onFailure(Call<CommentSend> call, Throwable t) {
            Toast.makeText(CommentActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}
    @Override
    public void onClick(View view) {
sendComment();
    }}

