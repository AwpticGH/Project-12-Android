package g10.manga.comicable.backend.app.listener.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.frontend.helper.ToastHelper;

public class UpdateListener<T extends AppCompatActivity> {

    public final OnCompleteListener<Void> onCompleteListener;

    public UpdateListener(T activity, AuthModel model) {
        onCompleteListener = (task) -> {
            if (task.isSuccessful()) {
                UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                        .setDisplayName(model.getFirst_name())
                        .build();
                AuthConfig.getFirebaseUser().updateProfile(profileUpdate);
                ToastHelper.updateUserSuccess(activity).show();
            }
            else {
                ToastHelper.updateUserFailed(activity).show();
            }
        };
    }

}
