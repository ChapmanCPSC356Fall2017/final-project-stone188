package edu.chapman.cpsc.beerrun.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

import edu.chapman.cpsc.beerrun.R;

/**
 *
 * Created by fried on 12/14/2017.
 */

public class WishListFragment extends Fragment {
    private TextView myList;
    private int i = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_wish_list, container, false);

        this.myList = v.findViewById(R.id.wish_list);

        SharedPreferences wishlist = getContext().getSharedPreferences(
                "wishList", Context.MODE_PRIVATE);

        Map<String,?> keys = wishlist.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()) {
            Log.d("map values", entry.getKey() + ": " +
                    entry.getValue().toString());

            myList.append(i + ". " + entry.getValue().toString() + "\n");
            i++;
        }

        return v;
    }
}
