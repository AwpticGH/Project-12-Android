package g10.manga.comicable.backend.app.controller.firebase;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class CheckpointController {

    public boolean create(CheckpointModel model) {
        DatabaseReference reference = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
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

    public CheckpointModel read(CheckpointModel checkpointModel, CollectionModel collectionModel) {
        Task<DataSnapshot> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .get();

        CheckpointModel model = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                for (DataSnapshot data : task.getResult().getChildren()) {
                    CheckpointModel result = data.getValue(CheckpointModel.class);
                    assert result != null;
                    if (result.getChapter().equals(checkpointModel.getChapter()) && result.getCollection().equals(collectionModel.getUid())) {
                        model = result;
                        break;
                    }
                }
            }
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return model;
    }

    public List<CheckpointModel> read(List<CollectionModel> collectionModels) {
        Task<DataSnapshot> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .get();

        List<CheckpointModel> models = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                for (DataSnapshot data : task.getResult().getChildren()) {
                    CheckpointModel result = data.getValue(CheckpointModel.class);
                    assert result != null;
                    for (CollectionModel collectionModel : collectionModels) {
                        if (result.getCollection().equals(collectionModel.getUid())) {
                            if (models == null) {
                                models = new ArrayList<>();
                            }
                            models.add(result);
                            break;
                        }
                    }
                }
            }
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return models;
    }

    public boolean update(CheckpointModel model) {
        Task<Void> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
                .child(model.getUid())
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

    public boolean delete(CheckpointModel model) {
        Task<Void> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_CHECKPOINT)
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
