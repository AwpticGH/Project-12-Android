package g10.manga.comicable.backend.app.controller.auth;

import android.app.Activity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.AuthModel;

public class RegisterController {

    public void createWithEmailAndPassword(AuthModel model, Activity activity, OnCompleteListener<AuthResult> onCompleteListener) {
        AuthConfig.getFirebaseAuth().createUserWithEmailAndPassword(model.getEmail(), model.getPassword())
                .addOnCompleteListener(activity, onCompleteListener);
    }

}
