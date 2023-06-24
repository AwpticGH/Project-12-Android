package g10.manga.comicable.backend.app.controller.firebase;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.model.BaseModel;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.backend.app.model.CheckpointModel;
import g10.manga.comicable.backend.app.model.CollectionModel;
import g10.manga.comicable.flag.app.ClazzFlag;

public class BaseController<T extends BaseModel> {

    private final Class<T> classType;
    private final String reference;

    public BaseController(Class<T> classType, String reference) {
        this.classType = classType;
        this.reference = reference;
    }

    public boolean create(String uid, T model) {
        Task<Void> task = DatabaseConfig.getDatabaseReference(reference)
                .child(uid)
                .setValue(model);
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

    public T readByUid(String uid) {
        Task<DataSnapshot> task = DatabaseConfig.getDatabaseReference(reference)
                .child(uid)
                .get();
        T model = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                model = task.getResult().getValue(this.classType);
                assert model != null;
            }
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return model;
    }

    public T readByValue(Object value, String methodName) {
        Task<DataSnapshot> task = DatabaseConfig.getDatabaseReference(reference)
                .get();
        T model = null;
        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                for (DataSnapshot data : task.getResult().getChildren()) {
                    Method method = classType.getMethod(methodName);
                    if (this.classType.equals(AuthModel.class) && ClazzFlag.methodExists(AuthModel.class, methodName)) {
                        AuthModel result = data.getValue(AuthModel.class);
                        if (Objects.equals(method.invoke(result), value)) {
                            model = (T) result;
                            break;
                        }
                    }
                    else if (this.classType.equals(CollectionModel.class) && ClazzFlag.methodExists(CollectionModel.class, methodName)) {
                        CollectionModel result = data.getValue(CollectionModel.class);
                        if (Objects.equals(method.invoke(result), value)) {
                            model = (T) result;
                            break;
                        }
                    }
                    else if (this.classType.equals(CheckpointModel.class) && ClazzFlag.methodExists(CheckpointModel.class, methodName)) {
                        CheckpointModel result = data.getValue(CheckpointModel.class);
                        if (Objects.equals(method.invoke(result), value)) {
                            model = (T) result;
                            break;
                        }
                    }
                }
            }
        }
        catch (ExecutionException | InterruptedException | NoSuchMethodException |
               IllegalAccessException | InvocationTargetException | ClassCastException e) {
            e.printStackTrace();
        }

        return model;
    }

    public boolean update(String uid, T model) {
        Task<Void> task =  DatabaseConfig.getDatabaseReference(reference)
                .child(uid)
                .setValue(model);

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

    public boolean delete(String uid) {
        Task<Void> task = DatabaseConfig.getDatabaseReference(reference)
                .child(uid)
                .removeValue();

        boolean deleted = false;
        try {
            Tasks.await(task);
            deleted = task.isSuccessful();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
