package g10.manga.comicable.frontend.listener.firebase.database.users.profile;

import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.activity.auth.update.ButtonUpdateListener;

public class UsersReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    public UsersReadListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            EditText etEmail, etPassword, etFirstName, etLastName;
            etEmail = activity.findViewById(R.id.input_update_email);
            etPassword = activity.findViewById(R.id.input_update_password);
            etFirstName = activity.findViewById(R.id.input_update_first_name);
            etLastName = activity.findViewById(R.id.input_update_last_name);

            AuthModel model = task.getResult().getValue(AuthModel.class);
            if (model != null) {
                etEmail.setText(model.getEmail());
                etPassword.setText(model.getPassword());
                etFirstName.setText(model.getFirst_name());
                etLastName.setText(model.getLast_name());

                activity.getIntent().putExtra(IntentDictionary.AUTH_MODEL, model);
            }
            else {
                ToastHelper.readUserFailed(activity).show();
            }
        }
        else {
            ToastHelper.readUserFailed(activity).show();
            activity.finish();
        }
    }
}
