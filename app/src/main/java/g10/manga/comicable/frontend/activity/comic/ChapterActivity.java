package g10.manga.comicable.frontend.activity.comic;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.ChapterCall;
import g10.manga.comicable.backend.api.controller.traditional.ChapterController;
import g10.manga.comicable.backend.api.helper.EndpointHelper;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import g10.manga.comicable.backend.api.model.chapter.PaginationModel;
import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.ActivityFlag;
import g10.manga.comicable.flag.api.ResponseFlag;
import g10.manga.comicable.frontend.adapter.activity.chapter.ChapterAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.activity.comic.chapter.ButtonPaginationListener;
import g10.manga.comicable.frontend.listener.callback.ChapterCallback;

public class ChapterActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ChapterCall chapterCall;
    private ChapterCallback<ResponseModel<DataModel>> chapterCallback;
    private String endpoint;
    private CheckpointTask checkpointTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        if (ActivityFlag.isNew(this)) {
            toolbar = findViewById(R.id.toolbar_activity_chapter);
            setSupportActionBar(toolbar);

            chapterCall = new ChapterCall();
            chapterCallback = new ChapterCallback<>(this);
            endpoint = getIntent().getStringExtra(IntentDictionary.CHAPTER_ENDPOINT);
            if (endpoint != null && (!endpoint.isEmpty() || !endpoint.isBlank())) {
                toolbar.setTitle(getIntent().getStringExtra(IntentDictionary.SERIES_TITLE));
                initApiCall(endpoint);
            }
        }
        else {
            if (!endpoint.equals(getIntent().getStringExtra(IntentDictionary.CHAPTER_ENDPOINT))) {
                endpoint = getIntent().getStringExtra(IntentDictionary.CHAPTER_ENDPOINT);
                if (endpoint != null && (!endpoint.isBlank() || !endpoint.isEmpty())) {
                    toolbar.setTitle(getIntent().getStringExtra(IntentDictionary.SERIES_TITLE));
                    initApiCall(endpoint);
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
