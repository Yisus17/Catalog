package com.jesus.test.catalog.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jesus.test.catalog.R;
import com.jesus.test.catalog.adapters.AppListAdapter;
import com.jesus.test.catalog.models.Feed;

public class FeedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppListAdapter appListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //Obteniendo la data del feed
        Gson gson = new Gson();
        String feedString = getIntent().getStringExtra("feedString");
        Feed feed =  gson.fromJson(feedString, Feed.class);
        /****/

        fillGrid();


        appListAdapter.addList(feed.getEntry());


    }


    private void fillGrid() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        appListAdapter = new AppListAdapter(this);
        recyclerView.setAdapter(appListAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

    }
}
