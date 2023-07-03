package g10.manga.comicable.backend.app.task.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class DatabaseTask {

    public Task<Void> create(AuthModel model) {
        model.setUid(AuthConfig.getFirebaseUser().getUid());

        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .setValue(model);
    }

    public Task<DataSnapshot> read() {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .get();
    }

    public Task<Void> update(AuthModel model) {
        model.setUid(AuthConfig.getFirebaseUser().getUid());

        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .setValue(model);
    }

}
