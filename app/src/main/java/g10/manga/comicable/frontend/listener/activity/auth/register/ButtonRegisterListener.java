package g10.manga.comicable.frontend.listener.activity.auth.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.task.auth.AuthenticationTask;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.authentication.AuthenticationCreateListener;

public class ButtonRegisterListener extends BaseListener implements View.OnClickListener {

    public ButtonRegisterListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        AppCompatEditText etEmail = activity.findViewById(R.id.et_email_activity_register);
        AppCompatEditText etPassword = activity.findViewById(R.id.et_password_activity_register);
        AppCompatEditText etFirstName = activity.findViewById(R.id.et_first_name_activity_register);
        AppCompatEditText etLastName = activity.findViewById(R.id.et_last_name_activity_register);

        String email = Objects.requireNonNull(etEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(etPassword.getText()).toString().trim();
        String firstName = Objects.requireNonNull(etFirstName.getText()).toString().trim();
        String lastName = Objects.requireNonNull(etLastName.getText()).toString().trim();

        AuthModel authModel = new AuthModel();
        authModel.setEmail(email);
        authModel.setPassword(password);
        authModel.setFirst_name(firstName);
        authModel.setLast_name(lastName);

        AuthenticationTask authenticationTask = new AuthenticationTask();
        authenticationTask.create(authModel)
                .addOnCompleteListener(new AuthenticationCreateListener(activity, authModel));
    }
}
