package g10.manga.comicable.frontend.activity.auth;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BuildCompat;

import android.os.Bundle;
import android.widget.Button;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.task.auth.DatabaseTask;
import g10.manga.comicable.frontend.listener.activity.BackButtonListener;
import g10.manga.comicable.frontend.listener.activity.auth.update.ButtonUpdateListener;
import g10.manga.comicable.frontend.listener.firebase.database.users.profile.UsersReadListener;

public class UpdateActivity extends AppCompatActivity {

    @Override
    @OptIn(markerClass = BuildCompat.PrereleaseSdkCheck.class)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        DatabaseTask databaseTask = new DatabaseTask();
        databaseTask.read().addOnCompleteListener(new UsersReadListener(this));

        Button btnUpdate = findViewById(R.id.button_update_update);
        btnUpdate.setOnClickListener(new ButtonUpdateListener(this));

        BackButtonListener backButtonListener = new BackButtonListener(this);
        backButtonListener.init(true);
    }

}