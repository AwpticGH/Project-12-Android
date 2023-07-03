package g10.manga.comicable.backend.app.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class CollectionTask {

    public Task<DataSnapshot> read() {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .get();
    }

    public Task<Void> create(CollectionModel model) {
        DatabaseReference reference = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .push();
        model.setUid(reference.getKey());
        return reference.setValue(model);
    }

    public Task<Void> delete(CollectionModel model) {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .child(model.getUid())
                .removeValue();
    }
}
