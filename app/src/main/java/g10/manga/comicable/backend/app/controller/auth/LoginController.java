package g10.manga.comicable.backend.app.controller.auth;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;

import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.AuthModel;

public class LoginController {

    public boolean loginWithEmailAndPassword(AuthModel model) {
        Task<AuthResult> task = AuthConfig.getFirebaseAuth().signInWithEmailAndPassword(model.getEmail(), model.getPassword());
        boolean authenticated = false;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                authenticated = true;
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return authenticated;
    }
}
