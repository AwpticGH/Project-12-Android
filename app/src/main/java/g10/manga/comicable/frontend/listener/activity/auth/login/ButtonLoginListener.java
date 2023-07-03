package g10.manga.comicable.frontend.listener.activity.auth.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.task.auth.AuthenticationTask;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.authentication.AuthenticationLoginListener;

public class ButtonLoginListener extends BaseListener implements View.OnClickListener {

    public ButtonLoginListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        AppCompatEditText etEmail = activity.findViewById(R.id.et_email_activity_login);
        AppCompatEditText etPassword = activity.findViewById(R.id.et_password_activity_login);

        String email = Objects.requireNonNull(etEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(etPassword.getText()).toString().trim();

        AuthModel authModel = new AuthModel();
        authModel.setEmail(email);
        authModel.setPassword(password);

        AuthenticationTask task = new AuthenticationTask();
        task.login(authModel).addOnCompleteListener(new AuthenticationLoginListener(activity));
    }
}
