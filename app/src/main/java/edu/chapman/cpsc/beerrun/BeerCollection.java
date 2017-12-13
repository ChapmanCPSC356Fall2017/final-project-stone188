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
    public static final String API_KEY = "0e62b079fc775a1afe28e07ac58239fb";

    private static BeerCollection collection;

    public static BeerCollection GetInstance(){
        if(collection == null){
            collection  = new BeerCollection();
        }
        return collection;
    }

    private List<BeerModel> beers;

    private BeerCollection(){
        this.beers = new ArrayList<>();
    }

    public void setBeers(List<BeerResponse.DataBean> beerResponse)
    {
        for(int i = 0; i < beerResponse.size(); ++i){
            Log.i("TEST", "Generating instances of beers");

            BeerModel beer = new BeerModel();

            beer.setTitle(beerResponse.get(i).getName());
            beer.setDescription(beerResponse.get(i).getDescription());
            beer.setAbv(beerResponse.get(i).getAbv());
            beer.setIbu(beerResponse.get(i).getIbu());
            beer.setBrewery("test");

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
