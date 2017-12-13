package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc.beerrun.BeerCollection;
import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.models.BeerModel;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class InfoFragment extends Fragment {
    public static final String EXTRA_BEER_ID = "beer_id";

    private String abv = "";
    private String ibu = "";
    private String description = "";
    private String brewery = "";
    private String theBeer = "";

    private TextView title;
    private TextView info;
    private TextView line1;
    private TextView line2;
    private TextView line3;

    public BeerModel beer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String beerId = getActivity().getIntent().getExtras().getString(InfoFragment.EXTRA_BEER_ID);
        this.beer = BeerCollection.GetInstance().getBeer(beerId);


    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        this.title = v.findViewById(R.id.tv_info_title);
        this.info = v.findViewById(R.id.tv_all_info);
        this.line1 = v.findViewById(R.id.tv_address);
        this.line2 = v.findViewById(R.id.tv_phone);
        this.line3 = v.findViewById(R.id.tv_email);

        theBeer = beer.getTitle();
        description = beer.getDescription();
        brewery = beer.getBrewery();
        abv = beer.getAbv();
        ibu = beer.getIbu();

        title.setText(theBeer);
        info.setText(description);
        line1.setText(String.format("%s%s", getString(R.string.the_brewery), brewery));
        line2.setText(String.format("%s%s", getString(R.string.the_abv), abv));
        line3.setText(String.format("%s%s", getString(R.string.the_ibu), ibu));

        return v;
    }
}
