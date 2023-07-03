package g10.manga.comicable.frontend.listener.adapter.fragment.collection;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.activity.comic.ChapterActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonCheckpointListener extends BaseListener implements View.OnClickListener {

    private final String collectionTitle, collectionUid, endpoint;

    public ButtonCheckpointListener(AppCompatActivity activity, String collectionTitle, String collectionUid, String endpoint) {
        super(activity);
        this.collectionTitle = collectionTitle;
        this.collectionUid = collectionUid;
        this.endpoint = endpoint;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, ChapterActivity.class);
        intent.putExtra(IntentDictionary.SERIES_TITLE, collectionTitle);
        intent.putExtra(IntentDictionary.COLLECTION_UID, collectionUid);
        intent.putExtra(IntentDictionary.CHAPTER_ENDPOINT, endpoint);
        activity.startActivity(intent);
    }
}
