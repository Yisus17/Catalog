package com.jesus.test.catalog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jesus.test.catalog.models.Feed;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Gson gson = new Gson();
        String feedString = getIntent().getStringExtra("feedString");
        Feed feed =  gson.fromJson(feedString, Feed.class);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(feed.getEntry().get(0).getImName().getLabel());

    }
}
