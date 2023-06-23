package g10.manga.comicable.backend.app.listener.auth;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.frontend.activity.MainActivity;
import g10.manga.comicable.frontend.helper.ToastHelper;

public class LoginListener<T extends AppCompatActivity> {

    public final OnCompleteListener<AuthResult> onCompleteListener;

    public LoginListener(T activity) {
        onCompleteListener = (task) -> {
            if (task.isSuccessful()) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                ToastHelper.loginSuccess(activity).show();
                activity.finish();
            }
            else {
                if (task.isCanceled()) {
                    ToastHelper.loginCancelled(activity).show();
                }
                else {
                    ToastHelper.loginFailed(activity).show();
                }
            }
        };
    }

}
