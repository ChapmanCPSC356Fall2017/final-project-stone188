package edu.chapman.cpsc.beerrun.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.chapman.cpsc.beerrun.BeerTouchHelper;
import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.activities.MainActivity;
import edu.chapman.cpsc.beerrun.adapters.WishAdapter;

/**
 *
 * Created by fried on 12/14/2017.
 */

public class WishListFragment extends Fragment {
    MainActivity mainActivity;

    private WishAdapter mAdapter;
    private RecyclerView wishListView;

    private List<String>myList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       mainActivity = (MainActivity) getContext();
       setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_wish_list, container, false);

        final MainActivity mainActivity = (MainActivity) getContext();
        myList = new ArrayList<>();

        SharedPreferences wishlist = getContext().getSharedPreferences(
                mainActivity.identifier, Context.MODE_PRIVATE);

        Map<String,?> keys = wishlist.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()) {
            Log.d("map values", entry.getKey() + ": " +
                    entry.getValue().toString());

            myList.add(entry.getValue().toString());
        }
        mainActivity.liked.hide();

        this.wishListView = v.findViewById(R.id.rv_wishlist);
        this.mAdapter = new WishAdapter(myList, getContext());
        wishListView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new BeerTouchHelper(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(wishListView);

        wishListView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_info, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.back_option:

                BeerFragment beerFrag = new BeerFragment();
                mainActivity.showFrag(beerFrag);

                return true;

            default: return false;
        }
    }
}
