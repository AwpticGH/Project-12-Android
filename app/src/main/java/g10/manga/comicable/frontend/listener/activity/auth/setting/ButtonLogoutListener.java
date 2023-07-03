package g10.manga.comicable.frontend.listener.activity.auth.setting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import g10.manga.comicable.backend.app.task.auth.AuthenticationTask;
import g10.manga.comicable.frontend.activity.auth.LoginActivity;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonLogoutListener extends BaseListener implements View.OnClickListener {

    public ButtonLogoutListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        AuthenticationTask authenticationTask = new AuthenticationTask();
        boolean loggedOut = authenticationTask.logout();
        if (loggedOut) {
            Intent intent = new Intent(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
            ToastHelper.logoutSuccess(activity).show();
        }
        else {
            ToastHelper.logoutFailed(activity).show();
        }
    }
}
