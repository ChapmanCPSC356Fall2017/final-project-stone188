package edu.chapman.cpsc.beerrun.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.activities.MainActivity;
import edu.chapman.cpsc.beerrun.fragments.InfoFragment;
import edu.chapman.cpsc.beerrun.models.BeerModel;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.MyViewHolder>{
    private final String LOGTAG = "BeerAdapter";

    private Context mContext;
    private List<BeerModel> beerModelList;

    private String abv = "";
    private String ibu = "";
    private String description = "";
    private String theBeer = "";
    private String brewery = "";

    public BeerAdapter(Context mContext, List<BeerModel> beerModelList){
        this.mContext = mContext;
        this.beerModelList = beerModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_beer, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(beerModelList.get(position).getTitle());

        if(beerModelList.get(position).getUrl() != null) {
            Picasso.with(mContext)
                    .load(beerModelList.get(position).getUrl())
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.beer_main)
                    .fit()
                    .into(holder.image);
        }

        else{
            holder.image.setImageResource(R.drawable.beer_main);
        }

        this.theBeer = beerModelList.get(position).getTitle();
        this.description = beerModelList.get(position).getDescription();
        this.abv = beerModelList.get(position).getAbv();
        this.ibu = beerModelList.get(position).getIbu();
        this.brewery = beerModelList.get(position).getBrewery();
    }

    @Override
    public int getItemCount() {
        Log.d(LOGTAG, "getItemCount()");
        return beerModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageButton image;

        public MyViewHolder(View itemView){
            super(itemView);

            this.title = itemView.findViewById(R.id.tv_title_beer);
            this.image = itemView.findViewById(R.id.iv_beer);

            this.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InfoFragment infofrag = new InfoFragment();

                    Bundle bundle = new Bundle();
                    bundle.putString("theBeer", theBeer);
                    bundle.putString("description", description);
                    bundle.putString("abv", abv);
                    bundle.putString("ibu", ibu);
                    bundle.putString("brewery", brewery);

                    infofrag.setArguments(bundle);

                    ((MainActivity) mContext).showFrag(infofrag);

                }
            });
        }
    }
}
