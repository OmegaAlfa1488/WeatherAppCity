package com.example.mytest.Activities;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.mytest.ListItems;
import com.example.mytest.MyAdapter;
import com.example.mytest.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener     {
    public static String URL_DATA = "http://smktesting.herokuapp.com/api/products/";
    public static final String EXTRA_URL = "image";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_TEXT = "text";
    public static final String EXTRA_ID = "id";
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<ListItems> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();

        getRecyclerView();
    }
    private void getRecyclerView(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i=0; i<array.length(); i++){
                        JSONObject o = array.getJSONObject(i);
                        ListItems listItem = new ListItems(o.getString("id"),"http://smktesting.herokuapp.com/static/"
                                + o.getString("img"), "Detailed description: " + o.getString("text"),
                                o.getString("title"));
                        listItems.add(listItem);
                    }
                    adapter = new MyAdapter(listItems, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(ProductsActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }},
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
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailedActivity.class);
        ListItems clickedItem = listItems.get(position);
        intent.putExtra(EXTRA_ID, clickedItem.getId());
        intent.putExtra(EXTRA_URL, clickedItem.getImg());
        intent.putExtra(EXTRA_TITLE, clickedItem.getTitle());
        intent.putExtra(EXTRA_TEXT, clickedItem.getText());
        startActivity(intent);
    }
}