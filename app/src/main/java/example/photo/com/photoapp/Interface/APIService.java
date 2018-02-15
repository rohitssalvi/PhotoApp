package example.photo.com.photoapp.Interface;

import java.util.List;

import example.photo.com.photoapp.DataModel.PhotoDetails;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rohit on 2/14/2018.
 */

public interface APIService
{

        @GET("/photos")
        Call<List<PhotoDetails>> getPhotoList();


}
