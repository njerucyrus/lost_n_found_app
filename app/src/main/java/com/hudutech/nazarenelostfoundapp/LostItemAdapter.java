package com.hudutech.nazarenelostfoundapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


public class LostItemAdapter extends RecyclerView.Adapter<LostItemAdapter.ViewHolder> {
    private List<LostItem> lostItemList;
    private Context mContext;

    public LostItemAdapter(Context mContext, List<LostItem> lostItemList) {
        this.lostItemList = lostItemList;
        this.mContext = mContext;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lost_item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LostItem lostItem = lostItemList.get(position);
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        String dateLost = mSimpleDateFormat.format(lostItem.getDateLost());
        holder.mTitle.setText(lostItem.getItemName());
        holder.mItemDetails.setText("Description : "+lostItem.getItemDesc());
        holder.mLocation.setText("Location: "+lostItem.getLocation());
        holder.mLocationDetails.setText("Location details: "+lostItem.getLocationInfo());
        holder.mDateLost.setText("Lost On: "+dateLost);
        Drawable drawableImage = mContext.getResources().getDrawable(lostItem.getResId());

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.no_image_lost_itme);

        Glide.with(mContext)
                .load(drawableImage)
                .apply(requestOptions)
                .into(holder.mLostItemImage);


    }


    @Override
    public int getItemCount() {
        return lostItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle;
        TextView mItemDetails;
        TextView mLocation;
        TextView mLocationDetails;
        TextView mDateLost;
        ImageView mLostItemImage;


        public ViewHolder(final View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.txt_title);
            mItemDetails = itemView.findViewById(R.id.tv_item_description);
            mLocation = itemView.findViewById(R.id.tv_location);
            mLocationDetails = itemView.findViewById(R.id.tv_more_location_details);
            mDateLost = itemView.findViewById(R.id.tv_date_lost);
            mLostItemImage = itemView.findViewById(R.id.lost_image_icon);


        }

        @Override
        public void onClick(View view) {
            // [HANDLE CLICKS OF THE VIEWS]
        }
    }


}
