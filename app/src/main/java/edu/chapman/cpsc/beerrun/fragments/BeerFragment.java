package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONObject;

import edu.chapman.cpsc.beerrun.BeerCollection;
import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.adapters.BeerAdapter;
import edu.chapman.cpsc.beerrun.models.BeerResponse;
import edu.chapman.cpsc.beerrun.services.ApiClient;
import edu.chapman.cpsc.beerrun.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.test.InstrumentationRegistry.getContext;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class BeerFragment extends Fragment {

    private final String TAG = "BeerFragment";
    private BeerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_beer_list, container, false);

        RecyclerView beerListView = v.findViewById(R.id.rv_beers);

        this.mAdapter = new BeerAdapter();
        beerListView.setAdapter(mAdapter);

        beerListView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false));

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(beerListView);

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();

        ApiClient apiClient = new ApiClient();
        ApiInterface apiService = apiClient.getClient().create(ApiInterface.class);

        Call<BeerResponse> call = apiService.getAllBeers(BeerCollection.API_KEY);
        call.enqueue(new Callback<BeerResponse>() {
            @Override
            public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                if(response.isSuccessful()) {
                    BeerCollection.GetInstance().setBeers(response.body().getData());
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
}