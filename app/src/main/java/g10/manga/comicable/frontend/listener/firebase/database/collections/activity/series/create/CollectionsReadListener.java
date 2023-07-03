package g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series.create;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import g10.manga.comicable.backend.api.model.series.SeriesModel;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.backend.app.task.CollectionTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series.CollectionsCreateListener;

public class CollectionsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    private final SeriesModel model;
    private final AppCompatImageButton button;

    public CollectionsReadListener(AppCompatActivity activity, SeriesModel model, AppCompatImageButton button) {
        super(activity);
        this.model = model;
        this.button = button;
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        boolean isInCollection = false;
        if (task.isSuccessful()) {
            for (DataSnapshot data : task.getResult().getChildren()) {
                CollectionModel seriesModel = data.getValue(CollectionModel.class);
                if (seriesModel != null) {
                    if (seriesModel.getTitle().equals(model.getTitle())) {
                        isInCollection = true;
                        break;
                    }
                }
            }
            if (!isInCollection) {
                String uid = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION).push().getKey();

                CollectionModel collectionModel = new CollectionModel();
                collectionModel.setUser(AuthConfig.getFirebaseUser().getUid());
                collectionModel.setTitle(model.getTitle());
                collectionModel.setEndpoint(activity.getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT));

                CollectionTask newTask = new CollectionTask();
                CollectionsCreateListener newTaskListener = new CollectionsCreateListener(activity, button, uid);
                newTask.create(collectionModel, uid).addOnCompleteListener(newTaskListener);
            }
        }
        else {
            ToastHelper.networkError(activity).show();
        }
    }
}
