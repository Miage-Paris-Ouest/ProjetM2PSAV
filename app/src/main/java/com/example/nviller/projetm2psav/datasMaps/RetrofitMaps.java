package com.example.nviller.projetm2psav.datasMaps;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by mouna on 06/03/2018.
 */

public interface RetrofitMaps {

    /*
   * Retrofit get annotation with our URL
   * And our method that will return us details of student.
   */
    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyDN7RJFmImYAca96elyZlE5s_fhX-MMuhk")
    Call<Example> getNearbyPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);

}
