package g10.manga.comicable.frontend.listener.activity.auth.setting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import g10.manga.comicable.frontend.activity.auth.UpdateActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ButtonUpdateListener extends BaseListener implements View.OnClickListener {

    public ButtonUpdateListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, UpdateActivity.class);
        activity.startActivity(intent);
    }
}
