package g10.manga.comicable.flag.app;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;

public class AuthFlag {

    public static boolean isAuthenticated() {
        return AuthConfig.getFirebaseAuth().getCurrentUser() != null;
    }

}
