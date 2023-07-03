package g10.manga.comicable.frontend.listener.firebase.database.collections;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.R;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CollectionsDeleteListener extends BaseListener implements OnCompleteListener<Void> {

    private final AppCompatImageButton button;

    public CollectionsDeleteListener(AppCompatActivity activity, AppCompatImageButton button) {
        super(activity);
        this.button = button;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            ToastHelper.deleteCollectionSuccess(activity).show();
            button.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.ic_favorite_heart_button_filled));
        }
        else {
            ToastHelper.deleteCollectionFailed(activity).show();
        }
    }
}
