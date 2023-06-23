package g10.manga.comicable.backend.app.listener.auth;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;
import g10.manga.comicable.frontend.helper.ToastHelper;

public class RegisterListener<T extends AppCompatActivity> {

    public final OnCompleteListener<AuthResult> onCompleteListener;

    public RegisterListener(T activity, AuthModel model) {
        onCompleteListener = (task) -> {
            if (task.isSuccessful()) {
                String uid = AuthConfig.getFirebaseUser().getUid();
                model.setUid(uid);
                DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH).child(uid).setValue(model);
                UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                        .setDisplayName(model.getFirst_name())
                        .build();
                AuthConfig.getFirebaseUser().updateProfile(profileUpdate);
                ToastHelper.registerSuccess(activity).show();
            }
            else {
                ToastHelper.registerFailed(activity).show();
            }
        };
    }
}
