package com.sacos.sacosandorid.services;

/**
 * Created by renjith on 03/02/16.
 */
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.Call;
import retrofit.http.GET;

import com.sacos.sacosandorid.OkHttpHandler;
import com.sacos.sacosandorid.models.IPApiModel;
import com.squareup.okhttp.OkHttpClient;

public class IPService {

    private static IPServiceInterface iPServiceInterface;
    private static String baseUrl = "http://ip-api.com";

    public static IPServiceInterface getClient() {
        if (iPServiceInterface == null) {

            OkHttpClient okClient = OkHttpHandler.getClient();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            iPServiceInterface = client.create(IPServiceInterface.class);
        }
        return iPServiceInterface;
    }

    public interface IPServiceInterface {
        @GET("/json")
        Call<IPApiModel> getIPData();
    }
}