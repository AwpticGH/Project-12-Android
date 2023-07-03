package g10.manga.comicable.frontend.listener.activity.comic.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import g10.manga.comicable.frontend.activity.auth.SettingActivity;
import g10.manga.comicable.frontend.listener.BaseListener;

public class ImageViewLogoListener extends BaseListener implements View.OnClickListener {

    public ImageViewLogoListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, SettingActivity.class);
        activity.startActivity(intent);
    }
}
