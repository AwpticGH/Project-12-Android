package g10.manga.comicable.frontend.activity.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import g10.manga.comicable.R;
import g10.manga.comicable.flag.backend.firebase.AuthFlag;
import g10.manga.comicable.frontend.activity.comic.MainActivity;
import g10.manga.comicable.frontend.listener.activity.auth.login.ButtonLoginListener;
import g10.manga.comicable.frontend.listener.activity.auth.login.ButtonRegisterListener;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AppCompatButton btnLogin = findViewById(R.id.button_login_activity_login);
        AppCompatButton btnRegister = findViewById(R.id.button_register_activity_login);

        btnLogin.setOnClickListener(new ButtonLoginListener(this));
        btnRegister.setOnClickListener(new ButtonRegisterListener(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (AuthFlag.isAuthenticated()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


}