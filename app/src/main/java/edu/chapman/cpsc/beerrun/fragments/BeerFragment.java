package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.adapters.BeerAdapter;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class BeerFragment extends Fragment {
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
        this.mAdapter.notifyDataSetChanged();
    }
}