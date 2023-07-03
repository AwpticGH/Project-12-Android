package g10.manga.comicable.frontend.activity.comic;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.SeriesCall;
import g10.manga.comicable.backend.api.controller.traditional.SeriesController;
import g10.manga.comicable.backend.api.helper.EndpointHelper;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.ChapterModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import g10.manga.comicable.backend.api.model.series.DetailModel;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.backend.app.task.CollectionTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.ActivityFlag;
import g10.manga.comicable.flag.api.ResponseFlag;
import g10.manga.comicable.frontend.adapter.activity.series.ChaptersAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.activity.BackButtonListener;
import g10.manga.comicable.frontend.listener.callback.SeriesCallback;

public class SeriesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BackButtonListener backButtonListener;
    private ImageView ivCollection;

    private AppCompatButton btnCheckpoint;

    private SeriesCall seriesCall;
    private SeriesCallback<ResponseModel<DataModel>> seriesCallback;
    private String endpoint;
    private CollectionTask collectionTask;
    private CollectionModel collectionModel;
    private CheckpointTask checkpointTask;
    private CheckpointModel checkpointModel;
    private boolean favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        if (ActivityFlag.isNew(this)) {
            // Enable Back Button To Be Pressed
            backButtonListener = new BackButtonListener(this);

            toolbar = findViewById(R.id.toolbar_activity_series);
            setSupportActionBar(toolbar);

            collectionTask = new CollectionTask();
            checkpointTask = new CheckpointTask();

            seriesCall = new SeriesCall();
            seriesCallback = new SeriesCallback<>(this);
            endpoint = getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT);
            if (endpoint != null) {
                initApiCall(endpoint);
            }
        }
        else {
            if (!endpoint.equals(getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT))) {
                endpoint = getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT);
                if (endpoint != null && (!endpoint.isBlank() || !endpoint.isEmpty())) {
                    initApiCall(endpoint);
                }
            }
        }
        backButtonListener.init(false);
    }

    private void initApiCall(String endpoint) {
        String series = EndpointHelper.parseSeriesEndpointAsSeries(endpoint);
        seriesCall.get(series).enqueue(seriesCallback);
    }
}