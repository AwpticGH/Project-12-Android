package g10.manga.comicable.frontend.listener.activity.comic.chapter;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.activity.comic.ChapterActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonPaginationListener extends BaseListener implements View.OnClickListener {

    private final String endpoint;

    public ButtonPaginationListener(AppCompatActivity activity, String endpoint) {
        super(activity);
        this.endpoint = endpoint;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, ChapterActivity.class);
        intent.putExtra(IntentDictionary.CHAPTER_ENDPOINT, endpoint);
        intent.putExtra(IntentDictionary.SERIES_TITLE, activity.getIntent().getStringExtra(IntentDictionary.SERIES_TITLE));
        intent.putExtra(IntentDictionary.COLLECTION_UID, activity.getIntent().getStringExtra(IntentDictionary.COLLECTION_UID));

        activity.startActivity(intent);
        activity.finish();
    }
}
