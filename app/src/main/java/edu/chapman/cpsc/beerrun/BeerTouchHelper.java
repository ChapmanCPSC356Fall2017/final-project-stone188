package edu.chapman.cpsc.beerrun;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import edu.chapman.cpsc.beerrun.adapters.WishAdapter;

/**
 *
 * Created by fried on 12/15/2017.
 */

public class BeerTouchHelper extends ItemTouchHelper.SimpleCallback {
    private WishAdapter wishAdapter;

    public BeerTouchHelper(WishAdapter wishAdapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.wishAdapter = wishAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target){
        wishAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction){
        wishAdapter.remove(viewHolder.getAdapterPosition());
    }
}
