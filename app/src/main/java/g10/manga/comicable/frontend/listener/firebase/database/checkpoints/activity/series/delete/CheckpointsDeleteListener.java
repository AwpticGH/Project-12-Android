package g10.manga.comicable.frontend.listener.firebase.database.checkpoints.activity.series.delete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CheckpointsDeleteListener extends BaseListener implements OnCompleteListener<Void> {

    private final AppCompatImageButton button;

    public CheckpointsDeleteListener(AppCompatActivity activity, AppCompatImageButton button) {
        super(activity);
        this.button = button;
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            ToastHelper.deleteCollectionSuccess(activity).show();
            button.setBackground(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.ic_favorite_heart_button, null));
            activity.getIntent().removeExtra(IntentDictionary.COLLECTION_UID);
        }
    }
}
