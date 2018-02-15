package example.photo.com.photoapp.Utility;

import android.content.Context;

import example.photo.com.photoapp.DataModel.PhotoDetails;
import example.photo.com.photoapp.Interface.APIService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by rohit on 2/14/2018.
 */

public class ApiClientSingle
{
    public static final String BASE_URL = Constant.BASE_URL;


    private APIService mApiService;
    private Context mContext;


    public static Retrofit getInstance()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

}
