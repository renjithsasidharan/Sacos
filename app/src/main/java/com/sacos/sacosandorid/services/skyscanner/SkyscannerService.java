package com.sacos.sacosandorid.services.skyscanner;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import com.sacos.sacosandorid.models.skyscanner.autosuggest.AutosuggestResult;
import com.sacos.sacosandorid.models.skyscanner.SkyscannerModel;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class SkyscannerService {

    private static SkyscannerApiInterface skyscannerApiInterface;
    private static String baseUrl = "http://partners.api.skyscanner.net" ;
    private static String API_KEY = "prtl6749387986743898559646983194";

    public static SkyscannerApiInterface getClient() {
        if (skyscannerApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Log.d("SkyscannerService", "Request url = " + request.urlString());
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            skyscannerApiInterface = client.create(SkyscannerApiInterface.class);
        }
        return skyscannerApiInterface ;
    }

    public interface SkyscannerApiInterface {
        @GET("/apiservices/browsequotes/v1.0/IN/INR/en-US/{originPlace}/{destinationPlace}/anytime/anytime")
        Call<SkyscannerModel> browseQuotes(@Path("originPlace") String originPlace, @Path("destinationPlace") String destinationPlace, @Query("apiKey") String apiKey);

        @GET("/apiservices/autosuggest/v1.0/IN/INR/en-US")
        Call<AutosuggestResult> autosuggest(@Query("query") String query, @Query("apiKey") String apiKey);
    }

}
