package g10.manga.comicable.frontend.listener.adapter.fragment.project;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import g10.manga.comicable.backend.api.model.project.ProjectModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.activity.comic.SeriesActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonSeriesListener extends BaseListener implements View.OnClickListener {

    private final ProjectModel model;

    public ButtonSeriesListener(AppCompatActivity activity, ProjectModel model) {
        super(activity);
        this.model = model;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, SeriesActivity.class);
        intent.putExtra(IntentDictionary.SERIES_ENDPOINT, model.getSeries());
        activity.startActivity(intent);
    }
}
