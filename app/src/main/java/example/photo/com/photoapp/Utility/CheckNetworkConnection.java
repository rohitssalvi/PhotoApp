package example.photo.com.photoapp.Utility;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by rohit on 2/14/2018.
 */

public class CheckNetworkConnection
{


    public static boolean isInternetOn(Context c)
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( connectivityManager.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connectivityManager.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connectivityManager.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {

            // if connected with internet

            return true;

        }
        return false;
    }



}
