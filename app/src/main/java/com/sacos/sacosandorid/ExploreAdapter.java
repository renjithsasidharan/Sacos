package com.sacos.sacosandorid;

/**
 * Created by renjith on 03/02/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sacos.sacosandorid.models.ExploreModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreView> {

    private Context context;
    private List<ExploreModel> data;

    public ExploreAdapter(Context context, List<ExploreModel> data) {
        super();
        this.context = context;
        this.data = data;
    }


    @Override
    public ExploreView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_explore_cell, parent, false);
        ExploreView exploreView = new ExploreView(layoutView);
        return exploreView;
    }

    @Override
    public void onBindViewHolder(ExploreView holder, int position) {
        Picasso.with(context).setIndicatorsEnabled(true);
        Picasso
                .with(context)
                .load(data.get(position).getOutboundPictureUrl())
                .placeholder(R.drawable.explore_placeholder)
                .error(R.drawable.explore_placeholder)
                .into(holder.imageView);
        holder.price.setText(data.get(position).getPriceString());
        holder.destination.setText(data.get(position).getDestination());
        holder.days.setText(data.get(position).getDays());
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    class ExploreView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price;
        TextView destination;
        TextView days;

        public ExploreView(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.explore_img);
            price = (TextView) itemView.findViewById(R.id.explore_price);
            destination = (TextView) itemView.findViewById(R.id.explore_destination);
            days = (TextView) itemView.findViewById(R.id.explore_days);

        }
    }

    public void onNext(List<ExploreModel> newData, int page) {
        if (newData == null) {
            return;
        }
        data.addAll(newData);
        notifyItemRangeInserted(getItemCount(), newData.size() -1);
    }
}