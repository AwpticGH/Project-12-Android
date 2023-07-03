package g10.manga.comicable.frontend.activity.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.frontend.listener.activity.BackButtonListener;
import g10.manga.comicable.frontend.listener.activity.auth.setting.ButtonLogoutListener;
import g10.manga.comicable.frontend.listener.activity.auth.setting.ButtonUpdateListener;

public class SettingActivity extends AppCompatActivity {

    private Intent intentLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView tvUserName = findViewById(R.id.text_user_name);
        tvUserName.setText(AuthConfig.getFirebaseUser().getDisplayName());

        Button btnLogout = findViewById(R.id.button_logout);
        btnLogout.setOnClickListener(new ButtonLogoutListener(this));

        Button btnUpdate = findViewById(R.id.button_update);
        btnUpdate.setOnClickListener(new ButtonUpdateListener(this));

        BackButtonListener backButtonListener = new BackButtonListener(this);
        backButtonListener.init(true);
    }
}