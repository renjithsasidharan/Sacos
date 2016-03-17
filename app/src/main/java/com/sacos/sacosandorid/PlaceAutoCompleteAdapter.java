package com.sacos.sacosandorid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import com.sacos.sacosandorid.models.skyscanner.autosuggest.AutosuggestResult;
import com.sacos.sacosandorid.models.skyscanner.autosuggest.Place;
import com.sacos.sacosandorid.services.skyscanner.SkyscannerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by renjith on 05/01/16.
 */
public class PlaceAutoCompleteAdapter extends BaseAdapter implements Filterable {

    //private static final int MAX_RESULTS = 10;
    private Context mContext;
    private List<Place> resultList = new ArrayList<Place>();

    public PlaceAutoCompleteAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Place getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.place_autosuggest_cell, parent, false);
        }
        String countryName = getItem(position).getCountryName();
        String placeName  = getItem(position).getPlaceName();
        String location = "";
        if(countryName == placeName) {
            location  = countryName;
        } else {
            location = location.concat(placeName).concat(", ").concat(countryName);
        }
        ((TextView) convertView.findViewById(R.id.placename)).setText(location);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<Place> places = findPlaces(constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = places;
                    filterResults.count = places.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    resultList = (List<Place>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }

    /**
     * Returns a search result for the given book title.
     */
    private List<Place> findPlaces(String name) {
        SkyscannerService.SkyscannerApiInterface service = SkyscannerService.getClient();
        List<Place> places = new ArrayList<>();
        Call<AutosuggestResult> call = service.autosuggest(name, SkyscannerService.API_KEY);
        try {
            Response<AutosuggestResult> response = call.execute();
            if(response.isSuccess()) {
                AutosuggestResult result = response.body();
                places = result.getPlaces();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return places;
    }
}
