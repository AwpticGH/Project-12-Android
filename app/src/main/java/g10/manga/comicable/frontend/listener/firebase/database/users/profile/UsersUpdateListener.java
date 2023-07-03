package g10.manga.comicable.frontend.listener.firebase.database.users.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.frontend.activity.auth.UpdateActivity;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class UsersUpdateListener extends BaseListener implements OnCompleteListener<Void> {

    public UsersUpdateListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            ToastHelper.registerToDatabaseSuccess(activity);

            // To refresh the activity and get the newest data
            Intent intent = new Intent(activity, UpdateActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
        else {
            ToastHelper.registerToDatabaseFailed(activity);
        }
    }
}
