package g10.manga.comicable.backend.app.task.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.UserProfileChangeRequest;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;

public class AuthenticationTask {


    public Task<AuthResult> create(AuthModel model) {
        return AuthConfig.getFirebaseAuth().createUserWithEmailAndPassword(model.getEmail(), model.getPassword());
    }

    public Task<AuthResult> login(AuthModel model) {
        return AuthConfig.getFirebaseAuth().signInWithEmailAndPassword(model.getEmail(), model.getPassword());
    }

    public boolean logout() {
        AuthConfig.getFirebaseAuth().signOut();
        return AuthConfig.getFirebaseUser() == null;
    }

    public Task<Void> update(AuthModel model) {
        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(model.getFirst_name())
                .build();
        return AuthConfig.getFirebaseUser().updateProfile(profileUpdate);
    }

}
