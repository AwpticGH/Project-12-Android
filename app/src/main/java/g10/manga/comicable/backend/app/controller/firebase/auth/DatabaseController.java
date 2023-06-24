package g10.manga.comicable.backend.app.controller.firebase.auth;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;

import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class DatabaseController {

    public boolean create(AuthModel model) {
        Task<Void> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .setValue(model);
        boolean created = false;
        try {
            Tasks.await(task);
            created = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return created;
    }

    public AuthModel read() {
        Task<DataSnapshot> task =  DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .get();
        AuthModel model = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                model = task.getResult().getValue(AuthModel.class);
                assert model != null;
            }
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return model;
    }

    public boolean update(AuthModel model) {
        Task<Void> task =  DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .setValue(model);

        boolean updated = false;
        try {
            Tasks.await(task);
            updated = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return updated;
    }

}
