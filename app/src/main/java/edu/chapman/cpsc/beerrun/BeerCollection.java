package edu.chapman.cpsc.beerrun;

import android.util.Log;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import edu.chapman.cpsc.beerrun.models.BeerModel;
import edu.chapman.cpsc.beerrun.models.BeerResponse;
import edu.chapman.cpsc.beerrun.services.ApiClient;
import edu.chapman.cpsc.beerrun.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.support.test.InstrumentationRegistry.getContext;

/**
 *
 * Created by fried on 12/11/2017.
 */

public class BeerCollection {
    private static final String TAG = "BeerCollection";
    private static final String API_KEY = "0e62b079fc775a1afe28e07ac58239fb";

    private static BeerCollection collection;

    public static BeerCollection GetInstance(){
        if(collection == null){
            collection  = new BeerCollection();
        }
        return collection;
    }

    private List<BeerModel> beers;
    private List<BeerResponse.DataBean> beerResponse;

    private BeerCollection(){
        this.beers = new ArrayList<>();
        this.beerResponse = new ArrayList<>();

        ApiClient apiClient = new ApiClient();
        ApiInterface apiService = apiClient.getClient().create(ApiInterface.class);

        Call<BeerResponse> call = apiService.getAllBeers(API_KEY);
        call.enqueue(new Callback<BeerResponse>() {
            @Override
            public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                if(response.isSuccessful()) {
                    beerResponse = response.body().getData();
                }
                else{
                    try{
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getContext(), jObjError.getString("message"),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e){
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BeerResponse> call, Throwable t) {
                Log.e(TAG, t.toString());

            }
        });

        for(int i = 0; i < beerResponse.size(); ++i){
            Log.i("TEST", "Generating instances of beers");

            BeerModel beer = new BeerModel();

            beer.setTitle(beerResponse.get(i).getName());
            beer.setDescription(beerResponse.get(i).getDescription());
            beer.setAbv(beerResponse.get(i).getAbv());
            beer.setIbu(beerResponse.get(i).getIbu());
            beer.setBrewery(beerResponse.get(i).getBreweries().get(i).getName());

            if(beerResponse.get(i).getLabels() != null) {
                beer.setUrl(beerResponse.get(i).getLabels().getMedium());
            }

            this.beers.add(beer);
        }
    }

    public List<BeerModel> getBeers(){
        return this.beers;
    }

    public BeerModel getBeer(String id){
        for(BeerModel beer : this.beers){
            if(beer.getId().equals(id)){
                return beer;
            }
        }
        return null;
    }
}
