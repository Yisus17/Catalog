package com.jesus.test.catalog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jesus.test.catalog.api.ItunesService;
import com.jesus.test.catalog.models.App;
import com.jesus.test.catalog.models.Feed;
import com.jesus.test.catalog.models.ItunesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private Retrofit retrofit;
    private final String URL = "https://itunes.apple.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getFeed();
    }

    private void getFeed(){
        ItunesService service = retrofit.create(ItunesService.class);
        Call<ItunesResponse> itunesResponseCall = service.getiTunesFeed();

        itunesResponseCall.enqueue(new Callback<ItunesResponse>() {
            @Override
            public void onResponse(Call<ItunesResponse> call, Response<ItunesResponse> response) {
                if (response.isSuccessful()){
                    ItunesResponse itunesResponse = response.body();
                    Feed feed = itunesResponse.getFeed();

                    Log.i("APLICACION",feed.getEntry().get(0).getImName().getLabel());


                }else{
                    Log.e("APLICACION", "onResponse: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ItunesResponse> call, Throwable t) {
                Log.e("APLICACION", "onFailure: "+ t.getMessage());
            }
        });

    }
}
