package g10.manga.comicable.flag.frontend.activity.series;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import g10.manga.comicable.R;

public class ButtonCollectionFlag {

    @SuppressLint("UseCompatLoadingForDrawables")
    public static boolean isFilled(AppCompatActivity activity, AppCompatImageButton button) {
        return button.getBackground() == activity.getResources().getDrawable(R.drawable.ic_favorite_heart_button_filled);
    }
}
