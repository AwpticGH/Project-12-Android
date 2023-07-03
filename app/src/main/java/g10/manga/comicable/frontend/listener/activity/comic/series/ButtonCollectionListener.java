package g10.manga.comicable.frontend.listener.activity.comic.series;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import g10.manga.comicable.backend.api.model.series.SeriesModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.backend.app.task.CollectionTask;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.frontend.activity.series.ButtonCollectionFlag;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series.CollectionsDeleteListener;
import g10.manga.comicable.frontend.listener.firebase.database.collections.activity.series.create.CollectionsReadListener;

public class ButtonCollectionListener extends BaseListener implements View.OnClickListener {

    private final SeriesModel model;
    private final CollectionTask task;
    private final CollectionsReadListener readListener;
    private final CollectionsDeleteListener deleteListener;
    private final AppCompatImageButton button;

    public ButtonCollectionListener(AppCompatActivity activity, SeriesModel model, AppCompatImageButton button) {
        super(activity);
        this.model = model;
        task = new CollectionTask();
        this.button = button;
        this.readListener = new CollectionsReadListener(activity, model, button);
        this.deleteListener = new CollectionsDeleteListener(activity, button);
    }

    @Override
    public void onClick(View view) {
        if (ButtonCollectionFlag.isFilled(activity)) {
            CollectionModel collectionModel = new CollectionModel();
            String uid = null;
            try {
                uid = activity.getIntent().getStringExtra(IntentDictionary.COLLECTION_UID);
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
            finally {
                if (uid != null) {
                    collectionModel.setUid(uid);
                    task.delete(collectionModel).addOnCompleteListener(deleteListener);
                }
            }
        }
        else {
            task.read().addOnCompleteListener(readListener);
        }
    }
}
