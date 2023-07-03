package g10.manga.comicable.frontend.listener.activity.auth.update;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.task.auth.AuthenticationTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.authentication.profile.AuthenticationUpdateListener;

public class ButtonUpdateListener extends BaseListener implements View.OnClickListener {

    public ButtonUpdateListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        EditText etEmail, etPassword, etFirstName, etLastName;
        etEmail = activity.findViewById(R.id.input_update_email);
        etPassword = activity.findViewById(R.id.input_update_password);
        etFirstName = activity.findViewById(R.id.input_update_first_name);
        etLastName = activity.findViewById(R.id.input_update_last_name);

        AuthModel model = (AuthModel) activity.getIntent().getSerializableExtra(IntentDictionary.AUTH_MODEL);
        if (model != null) {
            model.setEmail(etEmail.getText().toString().trim());
            model.setPassword(etPassword.getText().toString().trim());
            model.setFirst_name(etFirstName.getText().toString().trim());
            model.setLast_name(etLastName.getText().toString().trim());

            AuthenticationTask authenticationTask = new AuthenticationTask();
            authenticationTask.update(model).addOnCompleteListener(new AuthenticationUpdateListener(activity, model));
        }
        else {
            ToastHelper.updateUserFailed(activity).show();
        }

    }
}
