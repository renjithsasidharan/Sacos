package com.sacos.sacosandorid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sacos.sacosandorid.models.ExploreModel;
import com.sacos.sacosandorid.models.skyscanner.browsequotes.BrowseQuotes;
import com.sacos.sacosandorid.models.skyscanner.browsequotes.Currency;
import com.sacos.sacosandorid.models.skyscanner.browsequotes.Quote;
import com.sacos.sacosandorid.services.LocationService;
import com.sacos.sacosandorid.services.skyscanner.SkyscannerService;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrowseDatesFragment extends Fragment {

  private BrowseQuotes result = new BrowseQuotes();
  private List<ExploreModel> quotes =  new ArrayList<>();
  private BrowseDatesAdapter adapter;

  public BrowseDatesFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    final SkyscannerService.SkyscannerApiInterface service = SkyscannerService.getClient();
    final String market = LocationService.getCountryCode(getActivity().getApplicationContext());
    final View rootView = inflater.inflate(R.layout.fragment_browse_dates_all, container, false);
    RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.browse_dates_list_view);
    adapter = new BrowseDatesAdapter(SacosAndroid.getAppContext(), quotes);
    LinearLayoutManager lm = new LinearLayoutManager(getActivity(),
        LinearLayoutManager.VERTICAL,
        false);
    Bundle args = getArguments();
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(lm);
    mRecyclerView.setAdapter(adapter);
    Call<BrowseQuotes> call = service.browseQuotes(market, args.getString("fromAirportCode"), args.getString("toAirportCode"), SkyscannerService.ANYTIME, SkyscannerService.ANYTIME, SkyscannerService.API_KEY);

    call.enqueue(new Callback<BrowseQuotes>() {
      @Override
      public void onResponse(Response<BrowseQuotes> response, Retrofit retrofit) {
        if (response.isSuccess()) {
          Log.d("BrowseDates", "Got data");
          result = response.body();
          setExploreData(result);
          adapter.notifyDataSetChanged();
        } else {
          // response received but request not successful (like 400,401,403 etc)
          //Handle errors
        }
      }

      @Override
      public void onFailure(Throwable t) {
        Log.d("BrowseDates", "Failed to get data");
      }
    });

    return rootView;
  }

  public void setExploreData(BrowseQuotes result) {
    Currency currency;
    NumberFormat nf = NumberFormat.getInstance();

    for(Quote quote: result.getQuotes()) {
      DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
      DateTime fromDt = fmt.parseDateTime(quote.getOutboundLeg().getDepartureDate());
      DateTime toDt = fmt.parseDateTime(quote.getInboundLeg().getDepartureDate());
      int days = Days.daysBetween(new DateTime(fromDt), new DateTime(toDt)).getDays();
      ExploreModel exploreItem = new ExploreModel();
      exploreItem.setQuoteId(quote.getQuoteId());
      exploreItem.setPrice(quote.getMinPrice());
      exploreItem.setDestinationId(quote.getOutboundLeg().getDestinationId());
      exploreItem.setOriginIataCode(result.getIataCodeFromId(quote.getOutboundLeg().getOriginId()));
      exploreItem.setDestinationIataCode(result.getIataCodeFromId(quote.getOutboundLeg().getDestinationId()));
      exploreItem.setDestination(result.getPlaceNameFromId(quote.getOutboundLeg().getDestinationId()));
      if(days > 1) {
        exploreItem.setDays(Integer.toString(days).concat(" days"));
      } else {
        exploreItem.setDays(Integer.toString(days).concat(" day"));
      }
      currency = result.getCurrencies().get(0);
      exploreItem.setPriceString(currency.getSymbol() + " " + nf.format(quote.getMinPrice()));

      quotes.add(exploreItem);
    }
  }

}
