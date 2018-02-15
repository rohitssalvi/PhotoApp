package example.photo.com.photoapp.Home;

import java.util.List;

import example.photo.com.photoapp.DataModel.PhotoDetails;

/**
 * Created by rohit on 2/14/2018.
 */

public interface onLodingFinishListener {
    void onSuccess(List<PhotoDetails> photoDetails);
    void onFailure(String errorCode);
}
