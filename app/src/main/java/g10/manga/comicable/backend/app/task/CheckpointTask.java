package g10.manga.comicable.backend.app.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class CheckpointTask {

    public Task<Void> create(CheckpointModel model) {
        DatabaseReference reference = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .push();
        model.setUid(reference.getKey());
        return reference.setValue(model);
    }

    public Task<DataSnapshot> read() {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .get();
    }

    public Task<Void> update(CheckpointModel model) {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .child(model.getUid())
                .setValue(model);
    }

    public Task<Void> delete(CheckpointModel model) {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .child(model.getUid())
                .removeValue();
    }
}
