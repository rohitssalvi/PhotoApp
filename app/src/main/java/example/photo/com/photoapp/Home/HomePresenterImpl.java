package example.photo.com.photoapp.Home;

import java.util.List;

import example.photo.com.photoapp.DataModel.PhotoDetails;
import example.photo.com.photoapp.Interface.APIService;
import example.photo.com.photoapp.Utility.ApiClientSingle;

/**
 * Created by rohit on 2/14/2018.
 */

public class HomePresenterImpl implements HomePresenter,onLodingFinishListener
{
    private HomeView phomeView;
    private HomeModelImpl homeModel;





    public HomePresenterImpl(HomeView homeView)
    {
        phomeView=homeView;
        homeModel=new HomeModelImpl();

    }


    @Override
    public void getDataFromServer()
    {
       phomeView.onProgressShow();
       homeModel.getDataFromServer(this);

    }

    @Override
    public void onSuccess(List<PhotoDetails> photoDetails)
    {
        phomeView.onProgressHide();
        phomeView.onDisplayalbum(photoDetails);

    }

    @Override
    public void onFailure(String errorCode)
    {

    }
}
