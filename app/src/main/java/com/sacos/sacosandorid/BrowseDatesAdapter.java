package com.sacos.sacosandorid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sacos.sacosandorid.models.ExploreModel;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

/**
 * Created by renjith on 06/04/16.
 */
public class BrowseDatesAdapter extends RecyclerView.Adapter<BrowseDatesAdapter.BrowseDatesView> {

  private List<ExploreModel> data;

  public BrowseDatesAdapter(Context context, List<ExploreModel> data) {
    super();
    this.data = data;
  }

  @Override
  public BrowseDatesView onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_browse_dates_all_cell, parent, false);
    return new BrowseDatesView(layoutView);
  }

  @Override
  public void onBindViewHolder(BrowseDatesView holder, int position) {
    holder.price.setText(data.get(position).getPriceString());
    holder.onwardDate.setText(data.get(position).getOnwardDate().toString("E, d MMM"));
    holder.returnDate.setText(data.get(position).getReturnDate().toString("E, d MMM"));
    holder.onwardRoute.setText(data.get(position).getOriginIataCode().concat(" - ").concat(data.get(position).getDestinationIataCode()));
    holder.returnRoute.setText(data.get(position).getDestinationIataCode().concat(" - ").concat(data.get(position).getOriginIataCode()));
  }

  @Override
  public int getItemCount() {
    return this.data.size();
  }

  class BrowseDatesView extends RecyclerView.ViewHolder {
    TextView price;
    TextView onwardDate;
    TextView returnDate;
    TextView onwardRoute;
    TextView returnRoute;

    public BrowseDatesView(View itemView) {
      super(itemView);
      price = (TextView) itemView.findViewById(R.id.price);
      onwardDate = (TextView) itemView.findViewById(R.id.onward_date);
      returnDate = (TextView) itemView.findViewById(R.id.return_date);
      onwardRoute = (TextView) itemView.findViewById(R.id.onward_route);
      returnRoute = (TextView) itemView.findViewById(R.id.return_route);
    }
  }

  public void setData(List<ExploreModel> newdata) {
    data.addAll(newdata);
    notifyDataSetChanged();
  }
}
