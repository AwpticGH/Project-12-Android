package g10.manga.comicable.frontend.activity.comic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.ChapterCall;
import g10.manga.comicable.backend.api.helper.EndpointHelper;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.ActivityFlag;
import g10.manga.comicable.frontend.listener.callback.activity.chapter.ChapterCallback;
import g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.chapter.CheckpointsReadListener;

public class ChapterActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ChapterCall chapterCall;
    private ChapterCallback<ResponseModel<DataModel>> chapterCallback;
    private String collectionUid;
    private String endpoint;
    private CheckpointTask checkpointTask;
    private CheckpointsReadListener checkpointTaskListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        collectionUid = null;
        try {
            collectionUid = getIntent().getStringExtra(IntentDictionary.COLLECTION_UID);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (ActivityFlag.isNew(this)) {
            toolbar = findViewById(R.id.toolbar_activity_chapter);
            setSupportActionBar(toolbar);

            chapterCall = new ChapterCall();
            chapterCallback = new ChapterCallback<>(this);
            endpoint = getIntent().getStringExtra(IntentDictionary.CHAPTER_ENDPOINT);
            if (endpoint != null && (!endpoint.isEmpty() || !endpoint.isBlank())) {
                toolbar.setTitle(getIntent().getStringExtra(IntentDictionary.SERIES_TITLE));
                initApiCall(endpoint);
                if (collectionUid != null) {
                    checkpointTask = new CheckpointTask();
                    checkpointTaskListener = new CheckpointsReadListener(this, collectionUid, endpoint);
                    checkpointTask.read().addOnCompleteListener(checkpointTaskListener);
                }
            }
        }
        else {
            if (!endpoint.equals(getIntent().getStringExtra(IntentDictionary.CHAPTER_ENDPOINT))) {
                endpoint = getIntent().getStringExtra(IntentDictionary.CHAPTER_ENDPOINT);
                if (endpoint != null && (!endpoint.isBlank() || !endpoint.isEmpty())) {
                    toolbar.setTitle(getIntent().getStringExtra(IntentDictionary.SERIES_TITLE));
                    initApiCall(endpoint);
                    if (collectionUid != null) {
                        checkpointTask = new CheckpointTask();
                        checkpointTaskListener = new CheckpointsReadListener(this, collectionUid, endpoint);
                        checkpointTask.read().addOnCompleteListener(checkpointTaskListener);
                    }
                }
            }
        }
    }

    private void initApiCall(String endpoint) {
        String series = EndpointHelper.parseChapterEndpointAsSeries(endpoint);
        String chapter = EndpointHelper.parseChapterEndpointAsChapter(endpoint);
        chapterCall.get(series, chapter).enqueue(chapterCallback);
    }
}
