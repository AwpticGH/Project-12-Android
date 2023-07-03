package g10.manga.comicable.backend.app.config.firebase;

import com.google.firebase.BuildConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthConfig {

    public static FirebaseAuth getFirebaseAuth() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.useEmulator("10.0.2.2", 9099);
        return auth;
    }

    public static FirebaseUser getFirebaseUser() {
        return getFirebaseAuth().getCurrentUser();
    }

}
