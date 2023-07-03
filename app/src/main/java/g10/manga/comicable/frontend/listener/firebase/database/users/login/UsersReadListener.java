package g10.manga.comicable.frontend.listener.firebase.database.users.login;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.task.auth.DatabaseTask;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.users.UsersCreateListener;

public class UsersReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    public UsersReadListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            AuthModel model = task.getResult().getValue(AuthModel.class);
            if (model == null) {
                model = new AuthModel();
                model.setEmail(AuthConfig.getFirebaseUser().getEmail());
                model.setFirst_name(AuthConfig.getFirebaseUser().getDisplayName());

                DatabaseTask databaseTask = new DatabaseTask();
                UsersCreateListener listener = new UsersCreateListener(activity);
                databaseTask.create(model).addOnCompleteListener(listener);
            }
            else {
                ToastHelper.welcomeMessage(activity).show();
            }
        }
    }
}
