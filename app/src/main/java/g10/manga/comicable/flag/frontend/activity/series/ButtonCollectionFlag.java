package g10.manga.comicable.flag.frontend.activity.series;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.res.ResourcesCompat;

import java.util.Objects;

import g10.manga.comicable.R;

public class ButtonCollectionFlag {

    public static boolean isFilled(AppCompatActivity activity) {
        AppCompatImageButton button = activity.findViewById(R.id.ib_collection_activity_series);
        Drawable desiredDrawable = ResourcesCompat.getDrawable(activity.getResources(), R.drawable.ic_favorite_heart_button_filled, null);
        Drawable buttonDrawable = button.getBackground();

        if (desiredDrawable != null) {
            return Objects.equals(desiredDrawable.getConstantState(), buttonDrawable.getConstantState());
        }

        return false;
    }
}
