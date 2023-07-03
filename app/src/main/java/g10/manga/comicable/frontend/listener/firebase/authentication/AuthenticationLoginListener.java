package g10.manga.comicable.frontend.listener.firebase.authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import g10.manga.comicable.frontend.activity.comic.MainActivity;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class AuthenticationLoginListener extends BaseListener implements OnCompleteListener<AuthResult> {

    public AuthenticationLoginListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            ToastHelper.loginSuccess(activity).show();
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
        else {
            ToastHelper.loginFailed(activity).show();
        }
    }
}
