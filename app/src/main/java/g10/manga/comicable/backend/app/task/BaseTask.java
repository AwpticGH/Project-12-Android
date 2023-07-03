package g10.manga.comicable.backend.app.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;

public class BaseTask {

    protected Task<DataSnapshot> read(String path) {
        return DatabaseConfig.getDatabaseReference(path)
                .get();
    }
}
