package g10.manga.comicable.frontend.listener.adapter.activity.series;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import g10.manga.comicable.backend.api.model.series.ChapterModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.frontend.activity.series.ButtonCollectionFlag;
import g10.manga.comicable.frontend.activity.comic.ChapterActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonChapterListener extends BaseListener implements View.OnClickListener {

    private final ChapterModel model;

    public ButtonChapterListener(AppCompatActivity activity, ChapterModel model) {
        super(activity);
        this.model = model;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, ChapterActivity.class);
        intent.putExtra(IntentDictionary.CHAPTER_ENDPOINT, model.getEndpoint());
        intent.putExtra(IntentDictionary.SERIES_TITLE, activity.getIntent().getStringExtra(IntentDictionary.SERIES_TITLE));
        intent.putExtra(IntentDictionary.COLLECTION_UID, activity.getIntent().getStringExtra(IntentDictionary.COLLECTION_UID));

        activity.startActivity(intent);
    }
}
