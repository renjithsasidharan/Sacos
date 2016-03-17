package com.sacos.sacosandorid.services.skyscanner;

import com.sacos.sacosandorid.models.skyscanner.autosuggest.AutosuggestResult;
import com.sacos.sacosandorid.models.skyscanner.SkyscannerModel;
import com.sacos.sacosandorid.OkHttpHandler;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import com.squareup.okhttp.OkHttpClient;

public class SkyscannerService {

    private static SkyscannerApiInterface skyscannerApiInterface;
    private static String baseUrl = "http://partners.api.skyscanner.net";
    public static String API_KEY = "prtl6749387986743898559646983194";
    public static String ANYTIME = "Anytime";
    public static String ANYWHERE = "Anywhere";

    public static SkyscannerApiInterface getClient() {
        if (skyscannerApiInterface == null) {

            OkHttpClient okClient = OkHttpHandler.getClient();

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
        @GET("/apiservices/browsequotes/v1.0/{market}/INR/en-US/{originPlace}/{destinationPlace}/{outboundPartialDate}/{inboundPartialDate}")
        Call<SkyscannerModel> browseQuotes(@Path("market") String market, @Path("originPlace") String originPlace, @Path("destinationPlace") String destinationPlace, @Path("outboundPartialDate") String outboundPartialDate, @Path("inboundPartialDate") String inboundPartialDate,  @Query("apiKey") String apiKey);

        @GET("/apiservices/autosuggest/v1.0/IN/INR/en-US")
        Call<AutosuggestResult> autosuggest(@Query("query") String query, @Query("apiKey") String apiKey);
    }

}
