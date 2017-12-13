package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.activities.MainActivity;

/**
 * Created by fried on 11/29/2017.
 *
 */

public class MainMenueFragment extends Fragment{
    private Spinner spinner;
    private Button subBtn;
    private ArrayAdapter<String> adapter;
    private List<String> item = new ArrayList<>();

    public MainActivity mainActivity;

    public BeerFragment beerFrag;
    public EventFragment eventFrag;
    public InfoFragment infoFrag;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        item.add("Discover a Beer");
        item.add("Discover a Brewery");
        item.add("Discover an Event");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        this.spinner = v.findViewById(R.id.spinner);
        this.subBtn = v.findViewById(R.id.submitButton);

        this.adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();

        mainActivity = (MainActivity) getContext();

        this.subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selected = String.valueOf(spinner.getSelectedItem());

                switch(selected){
                    case "Discover a Beer":
                        beerFrag = new BeerFragment();
                        mainActivity.showFrag(beerFrag);

                        break;

                    case "Discover a Brewery":
                        infoFrag = new InfoFragment();
                        mainActivity.showFrag(infoFrag);

                        break;

                    case "Discover an Event":
                        eventFrag = new EventFragment();
                        mainActivity.showFrag(eventFrag);

                        break;

                    default:
                        Toast.makeText(getActivity(), "Nothing selected",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
