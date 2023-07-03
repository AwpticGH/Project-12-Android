package g10.manga.comicable.frontend.adapter.fragment.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.model.search.SearchModel;
import g10.manga.comicable.frontend.adapter.vholder.fragment.search.CardViewHolder;
import g10.manga.comicable.frontend.listener.adapter.fragment.search.SearchAdapterListener;

public class SearchAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private AppCompatActivity activity;
    private List<SearchModel> data;

    public SearchAdapter(AppCompatActivity activity, List<SearchModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list_search, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        SearchModel model = data.get(position);

        Glide.with(activity)
                .load(model.getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(holder.getIvThumbnail());

        holder.getTvTitle().setText(model.getTitle());
        holder.getTvStatus().setText(model.getStatus());
        holder.getTvRelease().setText(model.getRelease());
        holder.getTvRating().setText(model.getRating());
        holder.getTvGenre().setText(model.getGenres().toString());

        holder.getCvSearch().setOnClickListener(new SearchAdapterListener(activity, model));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
