package g10.manga.comicable.backend.app.controller.auth;

import android.app.Activity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class RegisterController {

    public boolean createWithEmailAndPassword(AuthModel model) {
        Task<AuthResult> task = AuthConfig.getFirebaseAuth().createUserWithEmailAndPassword(model.getEmail(), model.getPassword());
        boolean created = false;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                String uid = AuthConfig.getFirebaseUser().getUid();
                model.setUid(uid);
                DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH).child(uid).setValue(model);
                UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                        .setDisplayName(model.getFirst_name())
                        .build();
                AuthConfig.getFirebaseUser().updateProfile(profileUpdate);
                created = true;
            }
        }
        catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return created;
    }

}
