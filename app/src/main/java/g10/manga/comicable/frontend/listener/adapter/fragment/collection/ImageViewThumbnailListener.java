package g10.manga.comicable.frontend.listener.adapter.fragment.collection;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.activity.comic.SeriesActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ImageViewThumbnailListener extends BaseListener implements View.OnClickListener {

    private final String endpoint;

    public ImageViewThumbnailListener(AppCompatActivity activity, String endpoint) {
        super(activity);
        this.endpoint = endpoint;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, SeriesActivity.class);
        intent.putExtra(IntentDictionary.SERIES_ENDPOINT, endpoint);
        activity.startActivity(intent);
    }
}
