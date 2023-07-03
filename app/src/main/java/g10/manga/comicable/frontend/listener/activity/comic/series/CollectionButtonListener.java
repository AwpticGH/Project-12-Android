package g10.manga.comicable.frontend.listener.activity.comic.series;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.material.internal.BaselineLayout;

import g10.manga.comicable.backend.api.model.series.SeriesModel;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.backend.app.task.CollectionTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.frontend.activity.series.ButtonCollectionFlag;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.collections.CollectionsCreateListener;
import g10.manga.comicable.frontend.listener.firebase.database.collections.CollectionsDeleteListener;

public class CollectionButtonListener extends BaseListener implements View.OnClickListener {

    private final SeriesModel model;
    private final CollectionTask task;
    private final CollectionsCreateListener createListener;
    private final CollectionsDeleteListener deleteListener;
    private final AppCompatImageButton button;

    public CollectionButtonListener(AppCompatActivity activity, SeriesModel model, AppCompatImageButton button) {
        super(activity);
        this.model = model;
        task = new CollectionTask();
        this.button = button;
        this.createListener = new CollectionsCreateListener(activity, button);
        this.deleteListener = new CollectionsDeleteListener(activity, button);
    }

    @Override
    public void onClick(View view) {
        if (ButtonCollectionFlag.isFilled(activity, button)) {
            CollectionModel collectionModel = null;
            try {
                collectionModel = (CollectionModel) activity.getIntent().getSerializableExtra(IntentDictionary.COLLECTION_MODEL);
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
            finally {
                if (collectionModel != null) {
                    task.delete(collectionModel).addOnCompleteListener(deleteListener);
                }
            }
        }
        else {
            CollectionModel collectionModel = new CollectionModel();
            collectionModel.setUser(AuthConfig.getFirebaseUser().getUid());
            collectionModel.setTitle(model.getTitle());
            collectionModel.setEndpoint(activity.getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT));

            task.create(collectionModel).addOnCompleteListener(createListener);
        }
    }
}
