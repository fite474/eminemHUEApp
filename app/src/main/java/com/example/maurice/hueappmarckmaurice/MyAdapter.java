package com.example.maurice.hueappmarckmaurice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail_lamps, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

//    public BlindWallsAdapter(Context context, ArrayList<BlindWall> items) {
//        super( context, 0, items);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//
//        // Mural ophalen
//        BlindWall blindWall = getItem(position);
//
//        // View aanmaken of herbruiken
//        if( convertView == null ) {
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.listview_item_main,
//                    parent,
//                    false
//            );
//        }
//
//        TextView listViewItemTitle = convertView.findViewById(R.id.listviewItemTitle);
//
//        listViewItemTitle.setText(blindWall.getTitle());
//
//        final ImageView image = convertView.findViewById(R.id.listviewItemImage);
//
//        for(int i = 0; i < blindWall.getImagesUrls().size(); i++)
//        {
//            String imageUrlCurr = blindWall.getImagesUrls().get(i);
//
//            if(imageUrlCurr.contains("_1"))
//            {
//
//                Picasso.get().load(imageUrlCurr).into(image);
//            }
//        }
//        return convertView;
//    }
//}
