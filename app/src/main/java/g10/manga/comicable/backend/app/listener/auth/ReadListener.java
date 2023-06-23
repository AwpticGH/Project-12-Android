package g10.manga.comicable.backend.app.listener.auth;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.frontend.helper.ToastHelper;

public class ReadListener<T extends AppCompatActivity> implements OnCompleteListener<DataSnapshot> {

    private final T activity;

    public ReadListener(T activity) {
        this.activity = activity;
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            AuthModel model = task.getResult().getValue(AuthModel.class);
            assert model != null;

            TextView tvEmail = activity.findViewById(R.id.text_email);
            TextView tvPassword = activity.findViewById(R.id.text_password);
            TextView tvFirstName = activity.findViewById(R.id.text_name);
            TextView tvLastName;

            tvEmail.setText(model.getEmail());
            tvPassword.setText(model.getPassword());
            tvFirstName.setText(model.getFirst_name());
        }
        else {
            ToastHelper.readUserFail(activity).show();
        }
    }
}
