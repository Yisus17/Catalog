package com.jesus.test.catalog.api;

import com.jesus.test.catalog.models.ItunesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jaas1 on 9/27/2017.
 */

public interface ItunesService {

    @GET("/us/rss/topfreeapplications/limit=20/json")
    Call<ItunesResponse> getiTunesFeed();
}
