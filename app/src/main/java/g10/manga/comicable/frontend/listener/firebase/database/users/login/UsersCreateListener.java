package g10.manga.comicable.frontend.listener.firebase.database.users.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class UsersCreateListener extends BaseListener implements OnCompleteListener<Void> {

    public UsersCreateListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            ToastHelper.registerToDatabaseFailed(activity).show();
        }
        else {
            ToastHelper.reattemptRegisterToDatabaseSuccess(activity).show();
        }
    }
}

