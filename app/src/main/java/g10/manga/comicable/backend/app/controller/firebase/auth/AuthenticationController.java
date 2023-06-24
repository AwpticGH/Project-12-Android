package g10.manga.comicable.backend.app.controller.firebase.auth;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;

public class AuthenticationController {

    public boolean create(AuthModel model) {
        Task<AuthResult> task = AuthConfig.getFirebaseAuth().createUserWithEmailAndPassword(model.getEmail(), model.getPassword());
        boolean created = false;
        try {
            Tasks.await(task);
            created = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return created;
    }

    public boolean login(AuthModel model) {
        Task<AuthResult> task = AuthConfig.getFirebaseAuth().signInWithEmailAndPassword(model.getEmail(), model.getPassword());
        boolean authenticated = false;
        try {
            Tasks.await(task);
            authenticated = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return authenticated;
    }

    public boolean update(AuthModel model) {
        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(model.getFirst_name())
                .build();
        Task<Void> task = AuthConfig.getFirebaseUser().updateProfile(profileUpdate);
        boolean updated = false;
        try {
            Tasks.await(task);
            updated = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return updated;
    }
}
