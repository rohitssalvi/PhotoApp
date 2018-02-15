package example.photo.com.photoapp.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by rohit on 2/14/2018.
 */

public class PhotoDetails extends RealmObject
{
    @SerializedName("albumId")
    public int albumId;
    @SerializedName("id")
    public int pID;
    @SerializedName("title")
    public String pTitle;
    @SerializedName("url")
    public String pImageUrl;
    @SerializedName("thumbnailUrl")
    public String pThumbnailImageUrl;


}
