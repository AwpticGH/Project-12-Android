package g10.manga.comicable.frontend.listener.activity;

import android.window.OnBackInvokedDispatcher;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BuildCompat;

import g10.manga.comicable.frontend.listener.BaseListener;

public class BackButtonListener extends BaseListener {

    public BackButtonListener(AppCompatActivity activity) {
        super(activity);
    }

    @OptIn(markerClass = BuildCompat.PrereleaseSdkCheck.class)
    public void init(boolean finish) {
        if (BuildCompat.isAtLeastT()) {
            activity.getOnBackInvokedDispatcher()
                    .registerOnBackInvokedCallback(OnBackInvokedDispatcher.PRIORITY_DEFAULT, () -> {
                        if (finish) {
                            activity.finish();
                        }
                    });
        }
        else {
            activity.getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    if (finish) {
                        activity.finish();
                    }
                }
            });
        }
    }
}
