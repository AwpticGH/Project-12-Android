package g10.manga.comicable.frontend.listener.firebase.database.collections;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CollectionsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    public CollectionsReadListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            String endpoint = activity.getIntent().getStringExtra(IntentDictionary.SERIES_ENDPOINT);
            for (DataSnapshot data : task.getResult().getChildren()) {
                CollectionModel model = data.getValue(CollectionModel.class);
                if (model != null) {
                    if (model.getUser().equals(AuthConfig.getFirebaseUser().getUid()) && model.getEndpoint().equals(endpoint)) {
                        activity.getIntent().putExtra(IntentDictionary.COLLECTION_MODEL, model);
                        break;
                    }
                }
            }
        }
    }
}
