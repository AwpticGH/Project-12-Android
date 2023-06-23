package g10.manga.comicable.backend.app.controller.auth;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ExecutionException;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;
import g10.manga.comicable.frontend.activity.LoginActivity;
import g10.manga.comicable.frontend.activity.MainActivity;

public class AuthController {

    public AuthModel read() {
        Task<DataSnapshot> task =  DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .get();
        AuthModel model = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                model = task.getResult().getValue(AuthModel.class);
                assert model != null;
                return model;
            }
        }
        catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return model;
    }

    public Task<Void> update(AuthModel model) {
        return DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                .child(AuthConfig.getFirebaseUser().getUid())
                .setValue(model);
    }

}
