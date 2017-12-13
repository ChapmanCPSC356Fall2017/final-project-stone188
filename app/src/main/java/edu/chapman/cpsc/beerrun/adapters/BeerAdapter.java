package edu.chapman.cpsc.beerrun.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import edu.chapman.cpsc.beerrun.BeerCollection;
import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.fragments.InfoFragment;
import edu.chapman.cpsc.beerrun.models.BeerModel;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.MyViewHolder>{
    private final String LOGTAG = "BeerAdapter";

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_beer, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BeerModel beer = BeerCollection.GetInstance().getBeers().get(position);

        holder.setup(beer);
    }

    @Override
    public int getItemCount() {
        Log.d(LOGTAG, "getItemCount()");
        return BeerCollection.GetInstance().getBeers().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private BeerModel beer;

        private TextView title;
        private ImageButton image;

        public MyViewHolder(View itemView){
            super(itemView);

            this.title = itemView.findViewById(R.id.tv_title_beer);
            this.image = itemView.findViewById(R.id.iv_beer);

            this.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent beerIntent = new Intent(view.getContext(), InfoFragment.class)
                            .putExtra(InfoFragment.EXTRA_BEER_ID, beer.getId());

                    view.getContext().startActivity(beerIntent);
                }
            });
        }

        public void setup(BeerModel beer){
            this.beer = beer;
            this.title.setText(beer.getTitle());

            if(beer.getUrl() != null) {
                Picasso.with(MyViewHolder.this.itemView.getContext()).load(beer.getUrl())
                        .placeholder(R.drawable.progress_animation)
                        .error(R.drawable.beer_main)
                        .fit()
                        .into(this.image);
            }

            else{
                this.image.setImageResource(R.drawable.beer_main);
            }
        }
    }
}
