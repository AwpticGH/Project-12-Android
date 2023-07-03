package g10.manga.comicable.frontend.listener.adapter.fragment.home;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import g10.manga.comicable.backend.api.model.home.HomeModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.activity.comic.SeriesActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class HomeAdapterListener extends BaseListener implements View.OnClickListener {

    private final HomeModel model;

    public HomeAdapterListener(AppCompatActivity activity, HomeModel model) {
        super(activity);
        this.model = model;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, SeriesActivity.class);
        intent.putExtra(IntentDictionary.SERIES_ENDPOINT, model.getEndpoint());
        activity.startActivity(intent);
    }
}
