package example.photo.com.photoapp.Home;


import android.util.Log;

import java.util.List;

import example.photo.com.photoapp.DataModel.PhotoDetails;
import example.photo.com.photoapp.Interface.APIService;
import example.photo.com.photoapp.Utility.ApiClientSingle;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by rohit on 2/14/2018.
 */

public class HomeModelImpl implements HomeModel
{
    private Realm realm;

    @Override
    public void getDataFromServer(final onLodingFinishListener listener)
    {
        realm=Realm.getDefaultInstance();



        RealmResults<PhotoDetails> photo= realm.where(PhotoDetails.class).findAll();
        if(photo.size()<=0)
        {
            Retrofit retrofit=ApiClientSingle.getInstance();
            APIService apiService=retrofit.create(APIService.class);

            Call<List<PhotoDetails>> call=apiService.getPhotoList();
            call.enqueue(new Callback<List<PhotoDetails>>() {
                @Override
                public void onResponse(Call<List<PhotoDetails>> call, final Response<List<PhotoDetails>> response)
                {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm)
                        {
                          realm.insert(response.body());
                        }
                    });

                    RealmResults<PhotoDetails> photoData= realm.where(PhotoDetails.class).findAll();
                    if(photoData.size()>0)
                    {
                        listener.onSuccess(photoData);
                    }

                }

                @Override
                public void onFailure(Call<List<PhotoDetails>> call, Throwable t) {
                    listener.onFailure(t.toString());
                }
            });


        }else
        {
            listener.onSuccess(photo);
        }


    }
}
