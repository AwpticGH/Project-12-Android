package g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.series.delete.CheckpointsDeleteListener;
import g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.series.delete.CheckpointsReadListener;

public class CollectionsDeleteListener extends BaseListener implements OnCompleteListener<Void> {

    private final AppCompatImageButton button;

    public CollectionsDeleteListener(AppCompatActivity activity, AppCompatImageButton button) {
        super(activity);
        this.button = button;
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            CheckpointTask newTask = new CheckpointTask();
            CheckpointsReadListener newTaskListener = new CheckpointsReadListener(activity, button);
            newTask.read().addOnCompleteListener(newTaskListener);
        }
        else {
            ToastHelper.deleteCollectionFailed(activity).show();
        }
    }
}
