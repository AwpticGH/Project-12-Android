package g10.manga.comicable.frontend.listener.firebase.authentication.register;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.task.auth.DatabaseTask;
import g10.manga.comicable.frontend.activity.auth.LoginActivity;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.users.UsersCreateListener;

public class AuthenticationUpdateListener extends BaseListener implements OnCompleteListener<Void> {

    private final AuthModel model;

    public AuthenticationUpdateListener(AppCompatActivity activity, AuthModel model) {
        super(activity);
        this.model = model;
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            UsersCreateListener listener = new UsersCreateListener(activity);
            DatabaseTask databaseTask = new DatabaseTask();
            databaseTask.update(model).addOnCompleteListener(listener);

            Intent intent = new Intent(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
        else {
            ToastHelper.updateUserFailed(activity).show();
        }
    }
}
