package g10.manga.comicable.flag;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFlag {

    public static boolean isNew(AppCompatActivity activity) {
        return activity.getIntent() != null
                && (activity.getIntent().getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) == 0;
    }
}
