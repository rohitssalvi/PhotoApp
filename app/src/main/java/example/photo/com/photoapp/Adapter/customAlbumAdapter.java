package example.photo.com.photoapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.photo.com.photoapp.DataModel.PhotoDetails;
import example.photo.com.photoapp.R;

/**
 * Created by rohit on 2/14/2018.
 */

public class customAlbumAdapter extends RecyclerView.Adapter<customAlbumAdapter.customViewHolder>
{
  Context context;
  List<PhotoDetails> data;

    public customAlbumAdapter(Context c,List<PhotoDetails> data)
    {
        context=c;

        this.data=data;
    }

    @Override
    public customViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_home_data_view,parent,false);
        return new customViewHolder(v);

    }

    @Override
    public void onBindViewHolder(customViewHolder holder, int position)
    {
        Picasso.with(context).load(data.get(position).pThumbnailImageUrl).placeholder(R.drawable.placeholder).into(holder.imageView);
        holder.textView.setText(data.get(position).pTitle);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

     class customViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;

        public customViewHolder(View itemView)
        {

            super(itemView);
        imageView=(ImageView)itemView.findViewById(R.id.image_view);
        textView=(TextView)itemView.findViewById(R.id.tx_view) ;
        }
    }
}
