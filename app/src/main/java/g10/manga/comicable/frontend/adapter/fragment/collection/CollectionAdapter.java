package g10.manga.comicable.frontend.adapter.fragment.collection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.SearchCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.frontend.adapter.vholder.fragment.collection.CardViewHolder;
import g10.manga.comicable.frontend.listener.callback.fragment.collection.SearchCallback;

public class CollectionAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private final AppCompatActivity activity;
    private final List<CollectionModel> collectionModels;
    private final List<CheckpointModel> checkpointModels;
    private final SearchCall searchCall;

    public CollectionAdapter(AppCompatActivity activity, List<CollectionModel> collectionModels, List<CheckpointModel> checkpointModels) {
        this.activity = activity;
        this.collectionModels = collectionModels;
        this.checkpointModels = checkpointModels;
        this.searchCall = new SearchCall();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list_collection, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CollectionModel collection = collectionModels.get(position);
        CheckpointModel checkpoint = null;
        try {
            checkpoint = checkpointModels.get(position);
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        holder.getProgressBar().show();
        SearchCallback<ResponseModel<DataModel>> callback = new SearchCallback<>(activity, holder, collection, checkpoint);
        searchCall.get(collection.getTitle()).enqueue(callback);
    }

    @Override
    public int getItemCount() {
        return collectionModels.size();
    }
}
