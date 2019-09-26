package com.example.mytest.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mytest.AdapterComments;
import com.example.mytest.ListCommentsEvaluation;
import com.example.mytest.R;
import com.squareup.picasso.Picasso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import static com.example.mytest.Activities.ProductsActivity.EXTRA_ID;
import static com.example.mytest.Activities.ProductsActivity.EXTRA_TEXT;
import static com.example.mytest.Activities.ProductsActivity.EXTRA_TITLE;
import static com.example.mytest.Activities.ProductsActivity.EXTRA_URL;

public class DetailedActivity extends AppCompatActivity implements View.OnClickListener {

    public static String URL_DATA_COMMENTS = "http://smktesting.herokuapp.com/api/reviews/";
    private List<ListCommentsEvaluation> listItemsComments;
    String id;
    private RecyclerView recyclerView;
    private AdapterComments adapterComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        listItemsComments = new ArrayList<>();
        Intent intent = getIntent();
        id = intent.getStringExtra(EXTRA_ID);
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String text = intent.getStringExtra(EXTRA_TEXT);
        ImageView imageView = findViewById(R.id.imageViewDetail);
        TextView viewTitle = findViewById(R.id.titleDetail);
        TextView viewText = findViewById(R.id.textDetail);
        Button button = findViewById(R.id.buttonIntent);
        button.setOnClickListener(this);
        Picasso.get().load(imageUrl).into(imageView);
        viewTitle.setText(title);
        viewText.setText(text);
        recyclerView = findViewById(R.id.recyclerViewComments);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getComments();
    }

    private void getComments() {
        StringRequest stringRequest = new StringRequest
                (Request.Method.GET, URL_DATA_COMMENTS + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = array.getJSONObject(i);
                        ListCommentsEvaluation listCommentsEvaluation = new ListCommentsEvaluation
                                ("Comment: " + o.getString("text"),"rate: " + o.getString("rate"));
                        listItemsComments.add(listCommentsEvaluation);
                    }
                    adapterComments = new AdapterComments(listItemsComments,getApplicationContext());
                    recyclerView.setAdapter(adapterComments);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(this,CommentActivity.class);
        intent.putExtra("idProduct",id);
        startActivity(intent);
    }
}