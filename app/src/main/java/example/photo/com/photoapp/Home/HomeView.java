package example.photo.com.photoapp.Home;

import java.util.List;

import example.photo.com.photoapp.DataModel.PhotoDetails;

/**
 * Created by rohit on 2/14/2018.
 */

public interface HomeView
{
    void onProgressShow();
    void onProgressHide();
    void onDisplayalbum(List<PhotoDetails> mpPhotoDetails);
    void onDisplayError(String error);
}
