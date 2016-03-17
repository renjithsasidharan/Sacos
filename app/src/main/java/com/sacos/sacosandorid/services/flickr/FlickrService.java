package com.sacos.sacosandorid.services.flickr;

import com.sacos.sacosandorid.models.flickr.search.FlickrSearchResults;
import com.sacos.sacosandorid.models.flickr.search.Photo;
import com.sacos.sacosandorid.OkHttpHandler;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import com.squareup.okhttp.OkHttpClient;

public class FlickrService {

    private static FlickrApiInterface flickrApiInterface;
    private static String baseUrl = "https://api.flickr.com";
    public static String API_KEY = "08d398f095b89bb45e5a0d41a8cd42c8";
    public static String license = "1,2,3,4,5,6";
    private static String thumnailSize = "n";

    public static FlickrApiInterface getClient() {
        if (flickrApiInterface == null) {

            OkHttpClient okClient = OkHttpHandler.getClient();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            flickrApiInterface = client.create(FlickrApiInterface.class);
        }
        return flickrApiInterface ;
    }

    public static String composeUrl(Photo photo) {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_%s.jpg", photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret(), thumnailSize);
    }

    public interface FlickrApiInterface {
        @GET("/services/rest/?method=flickr.photos.search&sort=interestingness-desc&media=photos&per_page=1&page=1&format=json&nojsoncallback=1")
        Call<FlickrSearchResults> searchPhotos(@Query("license") String license, @Query("text") String text, @Query("api_key") String apiKey);

    }

}
