package g10.manga.comicable.backend.app.controller;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.CollectionModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class CollectionController {

    public CollectionModel read(String comic) {
        Task<DataSnapshot> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .get();

        CollectionModel model = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                for (DataSnapshot data : task.getResult().getChildren()) {
                    CollectionModel result = data.getValue(CollectionModel.class);
                    assert result != null;
                    if (result.getTitle().equals(comic) && result.getUser().equals(AuthConfig.getFirebaseUser().getUid())) {
                        model = result;
                    }
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            return model;
        }
    }
}
