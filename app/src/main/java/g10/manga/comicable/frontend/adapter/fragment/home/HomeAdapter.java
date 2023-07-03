package g10.manga.comicable.frontend.adapter.fragment.home;

import android.graphics.Color;
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
import g10.manga.comicable.backend.api.model.home.HomeModel;
import g10.manga.comicable.frontend.adapter.vholder.fragment.home.CardViewHolder;
import g10.manga.comicable.frontend.listener.adapter.fragment.home.HomeAdapterListener;

public class HomeAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private final List<HomeModel> data;
    private final AppCompatActivity activity;

    public HomeAdapter(AppCompatActivity activity, List<HomeModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list_home, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final HomeModel model = data.get(position);

        // CardView
        holder.getCardView().setOnClickListener(new HomeAdapterListener(activity, model));

        // Thumbnail
        Glide.with(activity.getApplicationContext())
                .load(model.getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(holder.getImageView());

        // Title
        holder.getTvTitle().setText(model.getTitle());

        // Type
        holder.getTvType().setText(model.getType());
        holder.getTvType().setTextColor(Color.parseColor(
                model.getType().equals("Manhua")
                ? "#ff27AE60" // Color for manhua
                : model.getType().equals("Manhwa")
                ? "#ffF2994A" // Color for manhwa
                : "#ffE8505B" // Color for manga
        ));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
