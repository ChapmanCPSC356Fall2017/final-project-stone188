package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc.beerrun.R;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class EventFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        return v;
    }
}
