package g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.R;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CollectionsCreateListener extends BaseListener implements OnCompleteListener<Void> {

    private final AppCompatImageButton button;
    private final String uid;

    public CollectionsCreateListener(AppCompatActivity activity, AppCompatImageButton button, String uid) {
        super(activity);
        this.button = button;
        this.uid = uid;
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            ToastHelper.createCollectionSuccess(activity).show();
            button.setBackgroundDrawable(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.ic_favorite_heart_button_filled, null));
            activity.getIntent().putExtra(IntentDictionary.COLLECTION_UID, uid);
        }
        else {
            ToastHelper.createCollectionFailed(activity).show();
        }
    }
}
