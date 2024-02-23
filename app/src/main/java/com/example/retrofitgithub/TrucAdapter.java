package com.example.retrofitgithub;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitgithub.databinding.ItemLongBinding;
import com.example.retrofitgithub.databinding.ItemTrucBinding;
import com.example.retrofitgithub.http.Truc;

import java.util.ArrayList;
import java.util.List;

public class TrucAdapter extends RecyclerView.Adapter<TrucAdapter.ViewHolder> {

    public List<Truc> trucList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemTrucBinding itemTrucBinding;

        public ViewHolder(ItemTrucBinding itemTrucBinding) {
            super(itemTrucBinding.getRoot());
            // Define click listener for the ViewHolder's View

            this.itemTrucBinding = itemTrucBinding;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     */
    public TrucAdapter() { trucList = new ArrayList<>(); }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        ItemTrucBinding itemTrucBinding = ItemTrucBinding
                .inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ViewHolder(itemTrucBinding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Truc currentTruc = trucList.get(position);
        viewHolder.itemTrucBinding.tvA.setText(currentTruc.a);
        viewHolder.itemTrucBinding.tvB.setText(currentTruc.b);
        viewHolder.itemTrucBinding.tvC.setText(currentTruc.c.toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return trucList.size();
    }
}

