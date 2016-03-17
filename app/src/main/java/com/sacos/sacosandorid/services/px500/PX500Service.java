package com.sacos.sacosandorid.services.px500;

import com.sacos.sacosandorid.OkHttpHandler;
import com.sacos.sacosandorid.models.PX500.search.PX500SearchResults;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by renjith on 07/02/16.
 */
public class PX500Service {

    private static PX500ApiInterface  px500ApiInterface;
    private static String baseUrl = "https://api.500px.com";
    public static String consumer_key = "qyJQv9M0HVFVmNFCJJ637JAQbXfTGBRyJIWDGlPQ";
    public static String license = "4,5,6";
    public static String thumnailSize = "21";

    public static PX500ApiInterface  getClient() {
        if (px500ApiInterface == null) {

            OkHttpClient okClient = OkHttpHandler.getClient();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            px500ApiInterface = client.create(PX500ApiInterface .class);
        }
        return px500ApiInterface ;
    }


    public interface PX500ApiInterface {
        //&only=Landscapes, City and Architecture, Nature, Travel, Underwater, Urban Exploration
        @GET("/v1/photos/search/?page=1&rpp=1&sort=highest_rating&exclude=People,Nude,Abstract,Family,Fashion,Macro,Wedding,Commercial,Celebrities,Journalism,Uncategorized")
        Call<PX500SearchResults> searchPhotos(@Query("license_type") String license, @Query("term") String term, @Query("image_size") String image_size, @Query("consumer_key") String consumer_key);

    }
}
