package g10.manga.comicable.frontend.activity.comic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.SeriesCall;
import g10.manga.comicable.backend.api.helper.EndpointHelper;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import g10.manga.comicable.backend.app.task.CollectionTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.ActivityFlag;
import g10.manga.comicable.frontend.listener.activity.BackButtonListener;
import g10.manga.comicable.frontend.listener.callback.activity.series.SeriesCallback;
import g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series.read.CollectionsReadListener;

public class SeriesActivity extends AppCompatActivity {

    private ContentLoadingProgressBar progressBar;
    private Toolbar toolbar;
    private BackButtonListener backButtonListener;
    private AppCompatButton btnCheckpoint;

    private SeriesCall seriesCall;
    private SeriesCallback<ResponseModel<DataModel>> seriesCallback;
    private String endpoint;
    private CollectionTask collectionTask;
    private CollectionsReadListener collectionsReadListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        if (ActivityFlag.isNew(this)) {
            // Enable Back Button To Be Pressed
            backButtonListener = new BackButtonListener(this);

            progressBar = findViewById(R.id.pb_activity_series);
            progressBar.show();

            toolbar = findViewById(R.id.toolbar_activity_series);
            setSupportActionBar(toolbar);

            collectionTask = new CollectionTask();
            collectionsReadListener = new CollectionsReadListener(this);

            seriesCall = new SeriesCall();
            seriesCallback = new SeriesCallback<>(this);
            endpoint = getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT);
            if (endpoint != null) {
                collectionTask.read().addOnCompleteListener(collectionsReadListener);
                initApiCall(endpoint);
            }
        }
        else {
            if (!endpoint.equals(getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT))) {
                endpoint = getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT);
                if (endpoint != null && (!endpoint.isBlank() || !endpoint.isEmpty())) {
                    collectionTask.read().addOnCompleteListener(collectionsReadListener);
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