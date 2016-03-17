package com.sacos.sacosandorid;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.mugen.Mugen;
import com.mugen.MugenCallbacks;
import com.mugen.attachers.BaseAttacher;
import com.sacos.sacosandorid.models.ExploreModel;
import com.sacos.sacosandorid.models.PX500.search.PX500SearchResults;
import com.sacos.sacosandorid.models.PX500.search.Photo;
import com.sacos.sacosandorid.models.skyscanner.Currency;
import com.sacos.sacosandorid.models.skyscanner.Quote;
import com.sacos.sacosandorid.models.skyscanner.SkyscannerModel;
import com.sacos.sacosandorid.services.LocationService;
import com.sacos.sacosandorid.services.px500.PX500Service;
import com.sacos.sacosandorid.services.skyscanner.SkyscannerService;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

//import com.sacos.sacosandorid.models.flickr.search.Photo;
//import com.sacos.sacosandorid.models.flickr.search.Photos;

public class ExploreActivity extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

  interface OnLoadingListener {
    void onLoadingStarted();

    void onLoadingFinished();
  }

  SwipeRefreshLayout mSwipeRefreshLayout;
  RecyclerView mRecyclerView;
  OnLoadingListener mListener;
  private ExploreAdapter adapter;
  private int page = 0;
  final private int limit = 20;
  boolean isLoading = false;
  SkyscannerModel result = new SkyscannerModel();
  List<ExploreModel> exploreData =  new ArrayList<>();
  List<ExploreModel> paginatedQuotes = new ArrayList<>();

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof OnLoadingListener) {
      mListener = (OnLoadingListener) activity;
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    final View rootView = inflater.inflate(R.layout.activity_explore, container, false);
    mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
    mSwipeRefreshLayout.setOnRefreshListener(this);
    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.explore_masonry_grid);
    adapter = new ExploreAdapter(SacosAndroid.getAppContext(), paginatedQuotes);
    //StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
    LinearLayoutManager lm = new LinearLayoutManager(getActivity(),
        LinearLayoutManager.VERTICAL,
        false);
    mRecyclerView.setHasFixedSize(true);
//    SpacesItemDecoration decoration = new SpacesItemDecoration(0);
//    mRecyclerView.addItemDecoration(decoration);
    mRecyclerView.setLayoutManager(lm);
    mRecyclerView.setAdapter(adapter);

    final SkyscannerService.SkyscannerApiInterface service = SkyscannerService.getClient();
    final String market = LocationService.getCountryCode(rootView.getContext());
    LocationService.getLocation(rootView.getContext(), new LocationService.LocationCallback() {
      @Override
      public void onNewLocationAvailable(Location location) {
        Log.d("Location", "my location is " + location.toString());

        String lat = String.valueOf(location.getLatitude());
        String lon = String.valueOf(location.getLongitude());
        String from = lat.concat(",").concat(lon).concat("-Latlong");
        Call<SkyscannerModel> call = service.browseQuotes(market, from, SkyscannerService.ANYWHERE, SkyscannerService.ANYTIME, SkyscannerService.ANYTIME, "prtl6749387986743898559646983194");

        call.enqueue(new Callback<SkyscannerModel>() {
          @Override
          public void onResponse(Response<SkyscannerModel> response, Retrofit retrofit) {
            if (mListener != null) {
              //to demo loading finished..
              mListener.onLoadingFinished();
            }
            mSwipeRefreshLayout.setRefreshing(false);
            if (response.isSuccess()) {
              Log.d("Explore", "Success....");
              result = response.body();
              setExploreData(result);
              adapter.onNext(loadQuotes(exploreData, limit, page), 0);
            } else {
              // response received but request not successful (like 400,401,403 etc)
              //Handle errors
            }
          }

          @Override
          public void onFailure(Throwable t) {

          }
        });
      }
    });
    return rootView;

  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    BaseAttacher attacher = Mugen.with(mRecyclerView, new MugenCallbacks() {
      @Override
      public void onLoadMore() {
        adapter.onNext(loadQuotes(exploreData, limit, page + 1), page);
        adapter.notifyItemRangeInserted(adapter.getItemCount(), paginatedQuotes.size() - 1);
      }

      @Override
      public boolean isLoading() {
        return isLoading;
      }

      @Override
      public boolean hasLoadedAllItems() {
        return false;
      }
    }).start();

    attacher.setLoadMoreEnabled(true);
    attacher.setLoadMoreOffset(4);

  }


  private List<ExploreModel> loadQuotes(List<ExploreModel> data, int offset, int currPage) {
    Log.d("customLoadMore", "On Load more..");
    int size = data.size();
    List<ExploreModel> quotes = new ArrayList<>();
    if (currPage * offset > size) {
      return quotes;
    }
    if (size < currPage * offset + offset) {
      quotes = data.subList(currPage * offset, size);
    } else {
      quotes = data.subList(currPage * offset, currPage * offset + offset);
    }
    page = currPage;
    searchPhotos(quotes);
    isLoading = false;
    return quotes;
  }

  private void searchPhotos(List<ExploreModel> quotes) {
    PX500Service.PX500ApiInterface service = PX500Service.getClient();
    for (int i = 0; i < quotes.size(); i++) {
      final ExploreModel quote = quotes.get(i);
      final int position = i;
      final String placeName = quote.getDestination();
      Call<PX500SearchResults> call = service.searchPhotos(PX500Service.license, placeName, PX500Service.thumnailSize, PX500Service.consumer_key);

      call.enqueue(new Callback<PX500SearchResults>() {
        @Override
        public void onResponse(Response<PX500SearchResults> response, Retrofit retrofit) {
          if (response.isSuccess()) {
            PX500SearchResults result = response.body();
            getPhotos(quote, result, position, placeName);

          } else {
            // response received but request not successful (like 400,401,403 etc)
            //Handle errors
          }
        }

        @Override
        public void onFailure(Throwable t) {


        }
      });
    }
  }

  private void getPhotos(ExploreModel quote, PX500SearchResults searchResults, int position, String placeName) {
    List<Photo> photos = searchResults.getPhotos();
    if (photos.size() > 0) {
      quote.setOutboundPictureUrl(photos.get(0).getImage_url());
      adapter.notifyItemChanged(position);
      Log.d("500PX photos found", placeName);
    } else {
      adapter.notifyItemRemoved(position);
      Log.d("500PX No photos found", placeName);
    }
  }

  @Override
  public void onRefresh() {

  }

  public void setExploreData(SkyscannerModel result) {
    boolean isExsiting;
    Currency currency;
    NumberFormat nf = NumberFormat.getInstance();

    for(Quote quote: result.getQuotes()) {
      isExsiting  = false;
      for(ExploreModel exploreItem: exploreData) {
        if(exploreItem.getDestinationId() == quote.getOutboundLeg().getDestinationId()) {
          isExsiting =  true;
          if(quote.getMinPrice() < exploreItem.getPrice()) {
            exploreItem.setPrice(quote.getMinPrice());
            currency = result.getCurrencies().get(0);
            if(currency.isSymbolOnLeft()) {
              if(currency.isSpaceBetweenAmountAndSymbol()) {
                exploreItem.setPriceString(currency.getSymbol() + " " + nf.format(quote.getMinPrice()));
              } else {
                exploreItem.setPriceString(currency.getSymbol() + nf.format(quote.getMinPrice()));
              }
            } else {
              if(currency.isSpaceBetweenAmountAndSymbol()) {
                exploreItem.setPriceString(nf.format(quote.getMinPrice()) + " " + currency.getSymbol());
              } else {
                exploreItem.setPriceString(nf.format(quote.getMinPrice()) + currency.getSymbol());
              }
            }
          }
        }
      }

      if(!isExsiting) {
        ExploreModel exploreItem = new ExploreModel();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTime fromDt = fmt.parseDateTime(quote.getOutboundLeg().getDepartureDate());
        DateTime toDt = fmt.parseDateTime(quote.getInboundLeg().getDepartureDate());
        int days = Days.daysBetween(new DateTime(fromDt), new DateTime(toDt)).getDays();
        exploreItem.setPrice(quote.getMinPrice());
        exploreItem.setDestinationId(quote.getOutboundLeg().getDestinationId());
        exploreItem.setDestination(result.getPlaceNameFromId(quote.getOutboundLeg().getDestinationId()));
        if(days > 1) {
          exploreItem.setDays(Integer.toString(days).concat(" days"));
        } else {
          exploreItem.setDays(Integer.toString(days).concat(" day"));
        }
        currency = result.getCurrencies().get(0);
        exploreItem.setPriceString(currency.getSymbol() + " " + nf.format(quote.getMinPrice()));

        exploreData.add(exploreItem);
      }
    }
  }
}
