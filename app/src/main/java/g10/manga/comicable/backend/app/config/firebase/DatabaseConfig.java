package g10.manga.comicable.backend.app.config.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class DatabaseConfig {

    public static DatabaseReference getDatabaseReference(String path) {
        return FirebaseDatabase.getInstance(DatabaseDictionary.URL_PRODUCTION).getReference(path);
    }
}
