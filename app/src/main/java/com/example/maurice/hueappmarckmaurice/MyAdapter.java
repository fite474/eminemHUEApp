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


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<Lamp> data;

    Context mContext;
    HueListner listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lamps_recycleview_item, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(mView);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getPosition());
            }
        });
        return mViewHolder;
    }

        @Override
    public void onBindViewHolder(ViewHolder lampViewHolder, int i) {
        lampViewHolder.bindLamps(data.get(i));
    }



//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.itemTitle.setText(Html.fromHtml(data.get(position).getTitle()));
//        if (!TextUtils.isEmpty(data.get(position).getThumbnailURL())) {
//            // I Love picasso library :) http://square.github.io/picasso/
//            Picasso.with(mContext).load(data.get(position).getThumbnailURL()).error(R.drawable.ic_no_image).
//                    placeholder(R.drawable.ic_no_image).
//                    transform(new RoundedCornersTransformation(5, 0)).
//                    into(holder.thumbnailImage);
//        } else {
//            holder.thumbnailImage.setImageResource(R.drawable.ic_no_image);
//        }
//    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public MyAdapter(Context mContext, ArrayList<Lamp> data, HueListner listener) {
        this.data = data;
        this.mContext = mContext;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lampId;
        public ImageView thumbnailImage;

        ViewHolder(View v) {
            super(v);
            lampId = (TextView) v.findViewById(R.id.item_lampIdTextView);

        }

        public void bindLamps(Lamp lamp) {
            lampId = (TextView) itemView.findViewById(R.id.item_lampIdTextView);
            lampId.setText(lamp.getDescription());

        }
    }
}














//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.LampViewHolder> {
//    private ArrayList<Lamp> lamps = new ArrayList<>();
//    private Context context;
//
//    private TextView lampId;
//
//    public MyAdapter(Context context, ArrayList<Lamp> lamps) {
//        this.context = context;
//        this.lamps = lamps;
//    }
//
//    public class LampViewHolder extends RecyclerView.ViewHolder {
//
////        @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
////        @Bind(R.id.restaurantNameTextView) TextView mNameTextView;
////        @Bind(R.id.categoryTextView) TextView mCategoryTextView;
////        @Bind(R.id.ratingTextView) TextView mRatingTextView;
//
//        private Context mContext;
//
//        public LampViewHolder(View itemView) {
//            super(itemView);
//            //ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//        }
//
//        public void bindLamps(Lamp lamp) {
//            lampId = (TextView) itemView.findViewById(R.id.item_lampIdTextView);
//            lampId.setText(lamp.getDescription());
//
//        }
//    }
//
//    @NonNull
//    @Override
//    public LampViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lamps_recycleview_item, viewGroup, false);
//        LampViewHolder viewHolder = new LampViewHolder(view);
//        return viewHolder;
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull LampViewHolder lampViewHolder, int i) {
//        lampViewHolder.bindLamps(lamps.get(i));
//    }
//
//    @Override
//    public int getItemCount() {
//        return lamps.size();
//    }
//
//
//}



//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//    private ArrayList<Lamp> mDataset;
//
//    // Provide a reference to the views for each data item
//    // Complex data items may need more than one view per item, and
//    // you provide access to all the views for a data item in a view holder
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        public View mView;
//        public MyViewHolder(View v) {
//            super(v);
//            mView = v;
//        }
//    }
//
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(ArrayList<Lamp> myDataset) {
//        mDataset = myDataset;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // create a new view
//
//        Lamp lamp = get
//
//        View v = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.activity_detail_lamps, parent, false);
//
//        TextView lampId = (TextView) v.findViewById(R.id.item_lampIdTextView);
//        lampId.setText(mDataset.);
//
//        MyViewHolder vh = new MyViewHolder(v);
//        return vh;
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        holder.mView.setText(mDataset.get(position).getDescription());
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }
//}

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
