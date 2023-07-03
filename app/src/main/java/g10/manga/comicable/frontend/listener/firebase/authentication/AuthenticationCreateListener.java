package g10.manga.comicable.frontend.listener.firebase.authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.task.auth.AuthenticationTask;
import g10.manga.comicable.frontend.activity.auth.LoginActivity;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.authentication.register.AuthenticationUpdateListener;

public class AuthenticationCreateListener extends BaseListener implements OnCompleteListener<AuthResult> {

    private final AuthModel model;

    public AuthenticationCreateListener(AppCompatActivity activity, AuthModel model) {
        super(activity);
        this.model = model;
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        Intent intent;
        if (task.isSuccessful()) {
            ToastHelper.registerSuccess(activity).show();
            AuthenticationTask authenticationTask = new AuthenticationTask();
            authenticationTask.update(model).addOnCompleteListener(new AuthenticationUpdateListener(activity, model));
        }
        else {
            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                ToastHelper.registerFailedDueToCollision(activity).show();
                intent = new Intent(activity, LoginActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
            else {
                ToastHelper.registerFailed(activity).show();
            }
        }
    }
}
