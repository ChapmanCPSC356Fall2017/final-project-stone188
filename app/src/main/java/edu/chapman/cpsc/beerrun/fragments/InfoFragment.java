package edu.chapman.cpsc.beerrun.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.activities.MainActivity;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class InfoFragment extends Fragment {
    public static final String EXTRA_BEER_ID = "beer_id";

    private MainActivity mainActivity;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mainActivity = (MainActivity) getContext();

        mainActivity.liked.hide();
        setHasOptionsMenu(true);
    }

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

        title.setText(nullCheck(theBeer, title));
        info.setText(nullCheck(description, info));
        line1.setText(String.format("%s%s", "brewery: ", nullCheck(brewery, line1)));
        line2.setText(String.format("%s%s", "abv: ", nullCheck(abv, line2)));
        line3.setText(String.format("%s%s", "ibu: ", nullCheck(ibu, line3)));

        return v;
    }

    public String nullCheck(String s, TextView tv){
        String replace = "NO ENTRY IN DATABASE";
        if(s.equals("null")){
            tv.setTypeface(Typeface.DEFAULT);
            tv.setTextColor(Color.parseColor("#D3D3D3"));
            return replace;
        }
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setTextColor(Color.parseColor("#000000"));
        return s;
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
