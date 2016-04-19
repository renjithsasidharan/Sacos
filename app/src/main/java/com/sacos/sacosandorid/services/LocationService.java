package com.sacos.sacosandorid.services;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.sacos.sacosandorid.models.IPApiModel;

import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by renjith on 31/01/16.
 */
public class LocationService {

  public static Location location;
  public static String countryCode = "";
  private static LocationManager lm = null;
  private static TelephonyManager tm = null;

  private static LocationManager getLocationManager(Context context) {
    if (lm == null) {
      lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }
    return lm;
  }

  private static TelephonyManager getTelephonyManager(Context context) {
    if (tm == null) {
      tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }
    return tm;
  }

  public interface LocationCallback {
    void onNewLocationAvailable(Location location);
  }


  @TargetApi(23)
  public static Location getLocation(Context context, final LocationCallback callback) {

    if (Build.VERSION.SDK_INT >= 23 &&
        ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      return null;
    }

    if (location == null) {
      location = getLocationManager(context).getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    if (location == null) {
      location = getLocationManager(context).getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
    }

    if (location == null) {
      location = getLocationManager(context).getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
    }

    if (location != null) {
      callback.onNewLocationAvailable(location);
    }

    if (location == null) {
      boolean isNetworkEnabled = getLocationManager(context).isProviderEnabled(LocationManager.NETWORK_PROVIDER);

      if (isNetworkEnabled) {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        getLocationManager(context).requestSingleUpdate(criteria, new LocationListener() {
          @Override
          public void onLocationChanged(Location location) {
            callback.onNewLocationAvailable(location);
          }

          @Override
          public void onStatusChanged(String provider, int status, Bundle extras) {
          }

          @Override
          public void onProviderEnabled(String provider) {
          }

          @Override
          public void onProviderDisabled(String provider) {
          }
        }, null);
      } else {
        boolean isGPSEnabled = getLocationManager(context).isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!isGPSEnabled) {
          Criteria criteria = new Criteria();
          criteria.setAccuracy(Criteria.ACCURACY_COARSE);
          getLocationManager(context).requestSingleUpdate(criteria, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
              callback.onNewLocationAvailable(new Location(location));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
          }, null);
        } else {
          //If still nothing get location from web service
          IPService.IPServiceInterface service = IPService.getClient();
          Call<IPApiModel> call = service.getIPData();

          call.enqueue(new Callback<IPApiModel>() {
            @Override
            public void onResponse(Response<IPApiModel> response, Retrofit retrofit) {
              Log.d("LocationService", "Getting location from web api, Status Code = " + response.code());
              if (response.isSuccess()) {
                IPApiModel result = response.body();
                if (result.getLat() != null && result.getLon() != null) {
                  Location webApiLocation = new Location("");
                  webApiLocation.setLatitude(result.getLat());
                  webApiLocation.setLongitude(result.getLon());
                  callback.onNewLocationAvailable(webApiLocation);
                }

              }
            }

            @Override
            public void onFailure(Throwable t) {

            }
          });
        }
      }
    }


    return location;
  }

  public static String getCountryCode(Context context) {

    if (!countryCode.isEmpty()) {
      return countryCode;
    }

    countryCode = getTelephonyManager(context).getNetworkCountryIso();

    if (countryCode.isEmpty()) {
      countryCode = context.getResources().getConfiguration().locale.getCountry();
    }

    return countryCode;
  }

  public static Locale getLocale(Context context) {
    return context.getResources().getConfiguration().locale;
  }
}
