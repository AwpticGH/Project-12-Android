package g10.manga.comicable.backend.app.config.firebase;

import com.google.firebase.auth.FirebaseAuth;

public class AuthConfig {

    public static FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

}
