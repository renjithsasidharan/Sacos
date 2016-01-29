package com.sacos.sacosandorid;

/**
 * Created by renjith on 04/01/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sacos.sacosandorid.models.skyscanner.SkyscannerModel;
import com.sacos.sacosandorid.models.skyscanner.Quote;


public class PlaceSearchResultAdapter extends BaseAdapter {
    private List<Quote> quotes ;
    private Context context ;
    private SkyscannerModel results;
    private final SimpleDateFormat incoming_format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private final SimpleDateFormat display_format = new SimpleDateFormat("d MMM");
    private final SimpleDateFormat day = new SimpleDateFormat("cccc");

    static class ViewHolder {
        private TextView fare;
        private TextView from_name;
        private TextView from_code;
        private TextView to_name;
        private TextView to_airport;
        private TextView from_date;
        private TextView to_date;
        private TextView from_day;
        private TextView to_day;
    }

    public PlaceSearchResultAdapter(Context ctx, SkyscannerModel results) {
        super();
        this.context = ctx ;
        this.results = results;
        this.quotes = results.getQuotes() ;
    }

    @Override
    public int getCount() {
        return this.quotes.size();
    }

    @Override
    public long getItemId(int i) {
        return 0 ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        Quote quote = quotes.get(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_search_results_cell, viewGroup, false);

            holder = new ViewHolder();
            holder.fare = (TextView) view.findViewById(R.id.result_quote);
            holder.from_name = (TextView) view.findViewById(R.id.result_from_name);
            holder.from_code = (TextView) view.findViewById(R.id.result_from_code);
            holder.to_name = (TextView) view.findViewById(R.id.result_to_name);
            holder.to_airport = (TextView) view.findViewById(R.id.result_to_code);
            holder.from_date = (TextView) view.findViewById(R.id.result_from_date);
            holder.to_date = (TextView) view.findViewById(R.id.result_to_date);
            holder.from_day = (TextView) view.findViewById(R.id.result_from_day);
            holder.to_day = (TextView) view.findViewById(R.id.result_to_day);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.fare.setText(String.valueOf(results.getCurrencies().get(0).getSymbol().concat(" ").concat(String.valueOf(quote.getMinPrice()))));
        holder.from_name.setText(String.valueOf(results.getPlaceNameFromId(quote.getOutboundLeg().getOriginId())));
        holder.from_code.setText(String.valueOf(quote.getOutboundLeg().getOriginId()));
        holder.to_name.setText(String.valueOf(results.getPlaceNameFromId(quote.getOutboundLeg().getDestinationId())));
        holder.to_airport.setText(String.valueOf(quote.getOutboundLeg().getDestinationId()));
        try {
            Date fromDate = incoming_format.parse(quote.getOutboundLeg().getDepartureDate());
            Date toDate = incoming_format.parse(quote.getInboundLeg().getDepartureDate());
            holder.from_date.setText(String.valueOf(display_format.format(fromDate)));
            holder.from_day.setText(String.valueOf(day.format(fromDate)));
            holder.to_date.setText(String.valueOf(display_format.format(toDate)));
            holder.to_day.setText(String.valueOf(day.format(toDate)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return view;
    }
}
