package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.adapters.BeerAdapter;
import edu.chapman.cpsc.beerrun.models.BeerModel;
import edu.chapman.cpsc.beerrun.models.BeerResponse;
import edu.chapman.cpsc.beerrun.services.ApiClient;
import edu.chapman.cpsc.beerrun.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class BeerFragment extends Fragment {
    private final String TAG = "BeerFragment";
    public static final String API_KEY = "0e62b079fc775a1afe28e07ac58239fb";

    private BeerAdapter mAdapter;
    private List<BeerModel> beers;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_beer_list, container, false);

        RecyclerView beerListView = v.findViewById(R.id.rv_beers);

        this.beers = new ArrayList<>();

        this.mAdapter = new BeerAdapter(getContext(), beers);
        beerListView.setAdapter(mAdapter);

        beerListView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false));

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(beerListView);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        makeCall();
    }

    public void makeCall(){
        ApiClient apiClient = new ApiClient();
        ApiInterface apiService = apiClient.getClient().create(ApiInterface.class);

        Call<BeerResponse> call = apiService.getAllBeers(API_KEY);
        call.enqueue(new Callback<BeerResponse>() {
            @Override
            public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                if(response.isSuccessful()) {
                    setBeers(response.body().getData());
                    mAdapter.notifyDataSetChanged();
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
            beer.setBrewery(beerResponse.get(i).getBreweries().get(0).getName());

            if(beerResponse.get(i).getLabels() != null) {
                beer.setUrl(beerResponse.get(i).getLabels().getMedium());
            }

            this.beers.add(beer);
        }
    }
}