package g10.manga.comicable.backend.app.controller.firebase;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return model;
    }

    public List<CollectionModel> read() {
        Task<DataSnapshot> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .get();

        List<CollectionModel> models = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                for (DataSnapshot data : task.getResult().getChildren()) {
                    CollectionModel result = data.getValue(CollectionModel.class);
                    assert result != null;
                    if (result.getUser().equals(AuthConfig.getFirebaseUser().getUid())) {
                        if (models == null) {
                            models = new ArrayList<>();
                        }
                        models.add(result);
                    }
                }
            }
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();;
        }

        return models;
    }

    public boolean create(CollectionModel model) {
        DatabaseReference reference = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .push();
        model.setUid(reference.getKey());
        Task<Void> task = reference.setValue(model);

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

    public boolean delete(CollectionModel model) {
        Task<Void> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_COLLECTION)
                .child(model.getUid())
                .removeValue();

        boolean deleted = false;
        try {
            Tasks.await(task);
            deleted = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
