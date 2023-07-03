package g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.chapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.flag.backend.firebase.CheckpointFlag;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CheckpointsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    private final String collectionUid;
    private final String endpoint;

    public CheckpointsReadListener(AppCompatActivity activity, String collectionUid, String endpoint) {
        super(activity);
        this.collectionUid = collectionUid;
        this.endpoint = endpoint;
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        Log.d(getClass().getSimpleName(), "onComplete");
        if (task.isSuccessful()) {
            CheckpointModel checkpointModel = null;
            for (DataSnapshot data : task.getResult().getChildren()) {
                CheckpointModel model = data.getValue(CheckpointModel.class);
                Log.d(getClass().getSimpleName(), "1 : " + collectionUid);
                if (model != null && model.getCollection().equals(collectionUid)) {
                    Log.d(getClass().getSimpleName(), "checkpointModel ga null");

                    checkpointModel = model;
                    break;
                }
            }
            CheckpointTask newTask;
            if (checkpointModel != null) {
                if (CheckpointFlag.isGreater(endpoint, checkpointModel.getEndpoint())) {
                    checkpointModel.setEndpoint(endpoint);

                    newTask = new CheckpointTask();
                    newTask.update(checkpointModel);
                }
            }
            else {
                checkpointModel = new CheckpointModel();
                checkpointModel.setCollection(collectionUid);
                checkpointModel.setEndpoint(endpoint);

                newTask = new CheckpointTask();
                newTask.create(checkpointModel);
            }
        }
    }
}
