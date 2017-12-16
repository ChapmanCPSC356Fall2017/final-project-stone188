package edu.chapman.cpsc.beerrun.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.activities.MainActivity;

/**
 * Created by fried on 12/15/2017.
 *
 */

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.MyViewHolder>{
    private List<String>myList;
    private Context mContext;

    public WishAdapter(List<String> myList, Context mContext){
        this.myList = myList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_wish, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String wish = myList.get(position);
        holder.init(wish);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public void swap(int apos, int bpos){
        Collections.swap(myList, apos, bpos);
        notifyItemMoved(apos, bpos);
    }

    public void remove(int pos){
        MainActivity mainActivity = (MainActivity) mContext;

        SharedPreferences remove_from_list = mContext.getSharedPreferences(
                mainActivity.identifier, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = remove_from_list.edit();
        editor.remove(myList.get(pos));
        editor.apply();

        myList.remove(pos);
        notifyItemRemoved(pos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView wishView;
        String wish;

        public MyViewHolder(View itemView){
            super(itemView);

            wishView = itemView.findViewById(R.id.my_wishes);
        }

        public void init(String wish){
            this.wish = wish;
            wishView.setText(wish);
        }
    }
}
