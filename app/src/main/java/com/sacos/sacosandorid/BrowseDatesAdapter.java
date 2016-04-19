package com.sacos.sacosandorid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sacos.sacosandorid.models.ExploreModel;

import java.util.List;

/**
 * Created by renjith on 06/04/16.
 */
public class BrowseDatesAdapter extends RecyclerView.Adapter<BrowseDatesAdapter.BrowseDatesView> {

  private Context context;
  private List<ExploreModel> data;

  public BrowseDatesAdapter(Context context, List<ExploreModel> data) {
    super();
    this.context = context;
    this.data = data;
  }

  @Override
  public BrowseDatesView onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_browse_dates_all_cell, parent, false);
    BrowseDatesView exploreView = new BrowseDatesView(layoutView);
    return exploreView;
  }

  @Override
  public void onBindViewHolder(BrowseDatesView holder, int position) {
    holder.price.setText(data.get(position).getPriceString());
    holder.destination.setText(data.get(position).getDestination());
  }

  @Override
  public int getItemCount() {
    return this.data.size();
  }

  class BrowseDatesView extends RecyclerView.ViewHolder {
    TextView price;
    TextView destination;

    public BrowseDatesView(View itemView) {
      super(itemView);

      price = (TextView) itemView.findViewById(R.id.browsedates_price);
      destination = (TextView) itemView.findViewById(R.id.browsedates_destination);

    }
  }

  public void setData(List<ExploreModel> newdata) {
    data.addAll(newdata);
    notifyDataSetChanged();
  }

}
