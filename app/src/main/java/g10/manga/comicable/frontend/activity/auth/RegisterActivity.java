package g10.manga.comicable.frontend.activity.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import g10.manga.comicable.R;
import g10.manga.comicable.flag.app.AuthFlag;
import g10.manga.comicable.frontend.listener.activity.auth.register.ButtonRegisterListener;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppCompatButton btnRegister = findViewById(R.id.button_register_activity_register);
        btnRegister.setOnClickListener(new ButtonRegisterListener(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (AuthFlag.isAuthenticated()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}