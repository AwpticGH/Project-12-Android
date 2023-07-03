package g10.manga.comicable.frontend.listener.firebase.database.checkpoints.fragment.collection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.frontend.adapter.fragment.collection.CollectionAdapter;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CheckpointsReadListener extends BaseListener implements OnCompleteListener<DataSnapshot> {

    private final List<CollectionModel> listCollection;

    public CheckpointsReadListener(AppCompatActivity activity, List<CollectionModel> listCollection) {
        super(activity);
        this.listCollection = listCollection;
    }

    @Override
    public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()) {
            List<CheckpointModel> listCheckpoint = new ArrayList<>();
            for (DataSnapshot data : task.getResult().getChildren()) {
                CheckpointModel checkpoint = data.getValue(CheckpointModel.class);
                if (checkpoint != null) {
                    for (CollectionModel collection : listCollection) {
                        if (checkpoint.getCollection().equals(collection.getUid())) {
                            listCheckpoint.add(checkpoint);
                        }
                    }
                }
            }

            CollectionAdapter collectionAdapter = new CollectionAdapter(activity, listCollection, listCheckpoint);

            RecyclerView rvCollection = activity.findViewById(R.id.rv_collection);
            rvCollection.setHasFixedSize(true);
            rvCollection.setLayoutManager(new LinearLayoutManager(activity));
            rvCollection.setAdapter(collectionAdapter);
        }
    }
}
