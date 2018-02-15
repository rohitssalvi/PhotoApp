package example.photo.com.photoapp.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.photo.com.photoapp.Adapter.customAlbumAdapter;
import example.photo.com.photoapp.DataModel.PhotoDetails;
import example.photo.com.photoapp.R;
import example.photo.com.photoapp.Utility.CheckNetworkConnection;

public class Home extends AppCompatActivity implements HomeView{

    @BindView(R.id.progress_view)
    ProgressBar hprogressBar;

    @BindView(R.id.recycle_data)
    RecyclerView hrecyclerView;

   private HomePresenterImpl homePresenter;
   private customAlbumAdapter hmCustomAlbumAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        if(CheckNetworkConnection.isInternetOn(this))
        {
            homePresenter=new HomePresenterImpl(this);
            homePresenter.getDataFromServer();
         }else
        {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onProgressShow()
    {
        hprogressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProgressHide()
    {
        hprogressBar.setVisibility(View.GONE);
    }



    @Override
    public void onDisplayalbum(List<PhotoDetails> mpPhotoDetails)
    {
        Log.i("tag data",mpPhotoDetails.toString());
        hrecyclerView.setVisibility(View.VISIBLE);
        hmCustomAlbumAdapter=new customAlbumAdapter(this,mpPhotoDetails);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        hrecyclerView.setLayoutManager(linearLayoutManager);
        hrecyclerView.setAdapter(hmCustomAlbumAdapter);

    }

    @Override
    public void onDisplayError(String error)
    {
        hrecyclerView.setVisibility(View.GONE);
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();

    }
}
