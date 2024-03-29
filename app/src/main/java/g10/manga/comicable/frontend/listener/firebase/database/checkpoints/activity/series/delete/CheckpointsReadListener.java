package g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.series.delete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.task.CheckpointTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CheckpointsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    private final AppCompatImageButton button;

    public CheckpointsReadListener(AppCompatActivity activity, AppCompatImageButton button) {
        super(activity);
        this.button = button;
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            String uid = null;
            try {
                uid = activity.getIntent().getStringExtra(IntentDictionary.COLLECTION_UID);
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
            finally {
                if (uid != null) {
                    boolean hasCheckpoint = false;
                    for (DataSnapshot data : task.getResult().getChildren()) {
                        CheckpointModel model = data.getValue(CheckpointModel.class);
                        if (model != null) {
                            if (model.getCollection().equals(uid)) {
                                hasCheckpoint = true;

                                CheckpointTask newTask = new CheckpointTask();
                                CheckpointsDeleteListener newTaskListener = new CheckpointsDeleteListener(activity, button);
                                newTask.delete(model).addOnCompleteListener(newTaskListener);
                                break;
                            }
                        }
                    }

                    if (!hasCheckpoint) {
                        ToastHelper.deleteCollectionSuccess(activity).show();
                        button.setBackground(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.ic_favorite_heart_button, null));
                        activity.getIntent().removeExtra(IntentDictionary.COLLECTION_UID);
                    }
                }
            }
        }
    }
}
