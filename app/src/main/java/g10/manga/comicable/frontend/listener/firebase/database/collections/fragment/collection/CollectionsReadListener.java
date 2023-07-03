package g10.manga.comicable.frontend.listener.firebase.database.collections.fragment.collection;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.checkpoints.fragment.collection.CheckpointsReadListener;

public class CollectionsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    public CollectionsReadListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            List<CollectionModel> listModel = new ArrayList<>();
            for (DataSnapshot data : task.getResult().getChildren()) {
                CollectionModel model = data.getValue(CollectionModel.class);
                if (model != null) {
                    if (model.getUser().equals(AuthConfig.getFirebaseUser().getUid())) {
                        listModel.add(model);
                    }
                }
            }

            CheckpointTask newTask = new CheckpointTask();
            CheckpointsReadListener newTaskListener = new CheckpointsReadListener(activity, listModel);
            newTask.read().addOnCompleteListener(newTaskListener);
        }
    }
}
