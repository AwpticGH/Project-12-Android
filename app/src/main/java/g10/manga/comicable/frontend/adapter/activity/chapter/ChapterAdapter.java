package g10.manga.comicable.frontend.adapter.activity.chapter;

import android.util.DisplayMetrics;
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
import g10.manga.comicable.frontend.adapter.vholder.activity.chapter.ChapterViewHolder;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewHolder> {

    private final AppCompatActivity activity;
    private final List<String> data;

    public ChapterAdapter(AppCompatActivity activity, List<String> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view_list_activity_chapter, parent, false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        String image = data.get(position);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Glide.with(activity.getApplicationContext())
                .load(image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(holder.getImageView().getWidth(), holder.getImageView().getHeight())
                .into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
