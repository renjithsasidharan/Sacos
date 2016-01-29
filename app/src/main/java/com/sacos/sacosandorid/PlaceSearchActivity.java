package com.sacos.sacosandorid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ListView;
import android.view.View;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.Bind;

import retrofit.Retrofit;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

import com.google.gson.Gson;

import com.sacos.sacosandorid.services.skyscanner.SkyscannerService;
import com.sacos.sacosandorid.models.skyscanner.SkyscannerModel;
import com.sacos.sacosandorid.models.skyscanner.autosuggest.Place;

public class PlaceSearchActivity extends AppCompatActivity {

    @Bind(R.id.to)
    EditText _to;
    @Bind(R.id.from)
    EditText _from;
    @Bind(R.id.find)
    Button _findButton;

    private PlaceSearchResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        final DelayAutoCompleteTextView fromPlace = (DelayAutoCompleteTextView) findViewById(R.id.from);
        fromPlace.setThreshold(3);
        fromPlace.setAdapter(new PlaceAutoCompleteAdapter(this)); // 'this' is Activity instance
        fromPlace.setLoadingIndicator(
                (android.widget.ProgressBar) findViewById(R.id.pb_loading_indicator_from));
        fromPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Place place = (Place) adapterView.getItemAtPosition(position);
                fromPlace.setText(place.getPlaceId().substring(0, place.getPlaceId().indexOf("-sky")));
            }
        });

        final DelayAutoCompleteTextView toPlace = (DelayAutoCompleteTextView) findViewById(R.id.to);
        toPlace.setThreshold(3);
        toPlace.setAdapter(new PlaceAutoCompleteAdapter(this)); // 'this' is Activity instance
        toPlace.setLoadingIndicator(
                (android.widget.ProgressBar) findViewById(R.id.pb_loading_indicator_to));
        toPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Place place = (Place) adapterView.getItemAtPosition(position);
                toPlace.setText(place.getPlaceId().substring(0, place.getPlaceId().indexOf("-sky")));
            }
        });

        _findButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                find();
            }
        });
    }

    public void find() {
        if (!validate()) {
            onSearchFailed();
            return;
        }

        _findButton.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(PlaceSearchActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Finding...");
        progressDialog.show();

        String to = _to.getText().toString();
        String from= _from.getText().toString();

        SkyscannerService.SkyscannerApiInterface service = SkyscannerService.getClient();
        Call<SkyscannerModel> call = service.browseQuotes(from, to, "prtl6749387986743898559646983194");

        call.enqueue(new Callback<SkyscannerModel>() {
            @Override
            public void onResponse(Response<SkyscannerModel> response, Retrofit retrofit) {
                progressDialog.dismiss();
                Log.d("PlaceSearchActivity", "Status Code = " + response.code());
                progressDialog.dismiss();
                if (response.isSuccess()) {
                    setContentView(R.layout.activity_search_result_list);
                    SkyscannerModel result = response.body();
                    ListView _searchListView = (ListView) findViewById(R.id.listview);
                    Log.d("PlaceSearchActivity", "response = " + new Gson().toJson(result));
                    adapter = new PlaceSearchResultAdapter(PlaceSearchActivity.this, result);
                    _searchListView.setAdapter(adapter);
                    //Intent intent = new Intent(this, PlaceSearchResultActivity.class);
                    //startActivity(intent);
                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String from= _from.getText().toString();
        String to = _to.getText().toString();

        if (from.isEmpty()) {
            _from.setError("is required");
            valid = false;
        } else {
            _from.setError(null);
        }

        if (to.isEmpty()) {
            _to.setError("is required");
            valid = false;
        } else {
            _to.setError(null);
        }

        return valid;
    }


    public void onSearchFailed() {
        Toast.makeText(getBaseContext(), "Search failed", Toast.LENGTH_LONG).show();
        _findButton.setEnabled(true);
    }

}
