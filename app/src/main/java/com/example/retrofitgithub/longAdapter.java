package com.example.retrofitgithub;


import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitgithub.databinding.ItemLongBinding;

import java.util.ArrayList;
import java.util.List;

public class longAdapter extends RecyclerView.Adapter<longAdapter.ViewHolder> {

    public List<Long> longList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemLongBinding itemLongBinding;

        public ViewHolder(ItemLongBinding itemLongBinding) {
            super(itemLongBinding.getRoot());
            // Define click listener for the ViewHolder's View

            this.itemLongBinding = itemLongBinding;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     */
    public longAdapter() { longList = new ArrayList<>(); }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        ItemLongBinding itemLongBinding = ItemLongBinding
                .inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ViewHolder(itemLongBinding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Long currentLong = longList.get(position);
        viewHolder.itemLongBinding.tvLong.setText(currentLong.toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return longList.size();
    }
}

