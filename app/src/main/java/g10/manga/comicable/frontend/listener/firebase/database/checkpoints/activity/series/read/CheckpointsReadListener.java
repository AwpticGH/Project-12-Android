package g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.series.read;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.activity.comic.series.ButtonCheckpointListener;

public class CheckpointsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    private final CollectionModel collectionModel;
    private final AppCompatButton button;

    public CheckpointsReadListener(AppCompatActivity activity, CollectionModel collectionModel, AppCompatButton button) {
        super(activity);
        this.collectionModel = collectionModel;
        this.button = button;
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            for (DataSnapshot data : task.getResult().getChildren()) {
                CheckpointModel model = data.getValue(CheckpointModel.class);
                if (model != null) {
                    if (model.getCollection().equals(collectionModel.getUid())) {
                        button.setOnClickListener(new ButtonCheckpointListener(activity, model.getEndpoint()));
                        button.setVisibility(View.VISIBLE);
                        break;
                    }
                }

            }
        }
    }
}
