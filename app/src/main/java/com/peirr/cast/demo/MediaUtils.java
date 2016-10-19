package com.peirr.cast.demo;

import android.net.Uri;
import android.util.Log;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.images.WebImage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kurt on 2016/10/19.
 */

public class MediaUtils {

    private static final String TAG = "MediaUtils";
    public static final String KEY_DESCRIPTION = "description";

    public static MediaInfo buildMediaInfo(String title, String studio, String subTitle,
                                            int duration, String url, String mimeType, String imgUrl, String bigImageUrl,
                                            List<MediaTrack> tracks) {
        MediaMetadata movieMetadata = new MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE);

        movieMetadata.putString(MediaMetadata.KEY_SUBTITLE, studio);
        movieMetadata.putString(MediaMetadata.KEY_TITLE, title);
        movieMetadata.addImage(new WebImage(Uri.parse(imgUrl)));
        movieMetadata.addImage(new WebImage(Uri.parse(bigImageUrl)));
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject();
            jsonObj.put(KEY_DESCRIPTION, subTitle);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to add description to the json object", e);
        }

        return new MediaInfo.Builder(url)
                .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                .setContentType(mimeType)
                .setMetadata(movieMetadata)
                .setMediaTracks(tracks)
                .setStreamDuration(duration * 1000)
                .setCustomData(jsonObj)
                .build();
    }


    public static MediaInfo getDummyVideo(String url,int duration){
        String title = "Big Buck Bunny";
        String studio = "";
        String subTitle = "The Curtain Rises";
        String mimeType = "videos/mp4";
        String imgUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Big_buck_bunny_poster_big.jpg/724px-Big_buck_bunny_poster_big.jpg";
        String bigImgUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Big_buck_bunny_poster_big.jpg/724px-Big_buck_bunny_poster_big.jpg";
        List<MediaTrack> tracks = new ArrayList<>();
        return buildMediaInfo(title,studio,subTitle,duration,url,mimeType,imgUrl,bigImgUrl,tracks);
    }
}
