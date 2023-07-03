package g10.manga.comicable.backend.app.config.firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import g10.manga.comicable.BuildConfig;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class DatabaseConfig {

    public static DatabaseReference getDatabaseReference(String path) {
        FirebaseDatabase database;
        database = FirebaseDatabase.getInstance(DatabaseDictionary.URL_DEVELOPMENT);
        database.useEmulator("10.0.2.2", 9000);
        return database.getReference(path);
    }
}
