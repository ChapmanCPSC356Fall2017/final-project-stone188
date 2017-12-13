package edu.chapman.cpsc.beerrun.services;

import java.util.Observable;

import edu.chapman.cpsc.beerrun.models.BeerResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * Created by fried on 12/9/2017.
 */

public interface ApiInterface {
    @GET("v2/beers?order=random&randomCount=10&hasLabel=Y&withBreweries=Y")
    Call<BeerResponse> getAllBeers(@Query("key") String apiKey);
}
