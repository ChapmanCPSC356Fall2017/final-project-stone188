package edu.chapman.cpsc.beerrun.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc.beerrun.R;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class InfoFragment extends Fragment {
    public static final String EXTRA_BEER_ID = "beer_id";

    private TextView title;
    private TextView info;
    private TextView line1;
    private TextView line2;
    private TextView line3;

    private String abv = "";
    private String ibu = "";
    private String description = "";
    private String brewery = "";
    private String theBeer = "";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        this.title = v.findViewById(R.id.tv_info_title);
        this.info = v.findViewById(R.id.tv_all_info);
        this.line1 = v.findViewById(R.id.tv_address);
        this.line2 = v.findViewById(R.id.tv_phone);
        this.line3 = v.findViewById(R.id.tv_email);

        Bundle bundle = getArguments();
        if(bundle != null) {
            this.theBeer = String.valueOf(bundle.getString("theBeer"));
            this.description = String.valueOf(bundle.getString("description"));
            this.abv = String.valueOf(bundle.getString("abv"));
            this.ibu = String.valueOf(bundle.getString("ibu"));
            this.brewery = String.valueOf(bundle.getString("brewery"));
        }

        title.setText(nullCheck(theBeer));
        info.setText(nullCheck(description));
        line1.setText(String.format("%s%s", getString(R.string.the_brewery), nullCheck(brewery)));
        line2.setText(String.format("%s%s", getString(R.string.the_abv), nullCheck(abv)));
        line3.setText(String.format("%s%s", getString(R.string.the_ibu), nullCheck(ibu)));

        return v;
    }

    public String nullCheck(String s){
        String replace = "NO ENTRY IN DATABASE";
        if(s.equals("null")){
            return replace;
        }
        return s;
    }
}
