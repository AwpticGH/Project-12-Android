package g10.manga.comicable.frontend.listener.callback.fragment.collection;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import g10.manga.comicable.backend.api.helper.EndpointHelper;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import g10.manga.comicable.backend.api.model.search.SearchModel;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;
import g10.manga.comicable.frontend.adapter.vholder.fragment.collection.CardViewHolder;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.adapter.fragment.collection.ButtonCheckpointListener;
import g10.manga.comicable.frontend.listener.adapter.fragment.collection.ImageViewThumbnailListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCallback<T> extends BaseListener implements Callback<T> {

    private final CardViewHolder holder;
    private final CollectionModel collection;
    private final CheckpointModel checkpoint;

    public SearchCallback(AppCompatActivity activity, CardViewHolder holder, CollectionModel collection, @Nullable CheckpointModel checkpoint) {
        super(activity);
        this.holder = holder;
        this.collection = collection;
        this.checkpoint = checkpoint;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) {
            ResponseModel<DataModel> responseModel = null;
            try {
                responseModel = (ResponseModel<DataModel>) response.body();
            }
            catch (ClassCastException e) {
                e.printStackTrace();
            }
            finally {
                if (responseModel != null) {
                    for (SearchModel model : responseModel.getData().getSearches()) {
                        if (model.getEndpoint().equals(collection.getEndpoint())) {
                            Glide.with(activity)
                                    .load(model.getThumbnail())
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .override(Target.SIZE_ORIGINAL)
                                    .into(holder.getIvThumbnail());

                            holder.getIvThumbnail().setOnClickListener(new ImageViewThumbnailListener(activity, collection.getEndpoint()));
                            holder.getTvTitle().setText(collection.getTitle());

                            if (checkpoint != null) {
                                holder.getTvCheckpoint().setText(EndpointHelper.parseChapterEndpointAsChapter(checkpoint.getEndpoint()));
                                holder.getTvCheckpoint().setVisibility(View.VISIBLE);

                                holder.getBtnCheckpoint().setOnClickListener(new ButtonCheckpointListener(activity, collection.getTitle(), collection.getUid(), checkpoint.getEndpoint()));
                                holder.getBtnCheckpoint().setVisibility(View.VISIBLE);
                            }

                            holder.getConstraintLayout().setVisibility(View.VISIBLE);
                            holder.getProgressBar().hide();
                        }
                    }
                }
            }
        }
        else {
            ToastHelper.networkError(activity).show();
            holder.getProgressBar().hide();
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        ToastHelper.unknownError(activity).show();
        holder.getProgressBar().hide();
    }
}
