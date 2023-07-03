package g10.manga.comicable.frontend.listener.activity.auth.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import g10.manga.comicable.frontend.activity.auth.RegisterActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonRegisterListener extends BaseListener implements View.OnClickListener {

    public ButtonRegisterListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
