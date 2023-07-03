package g10.manga.comicable.frontend.adapter.fragment.project;

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
import g10.manga.comicable.backend.api.model.project.ProjectModel;
import g10.manga.comicable.frontend.adapter.vholder.fragment.project.CardViewHolder;
import g10.manga.comicable.frontend.listener.adapter.fragment.project.ButtonChapterListener;
import g10.manga.comicable.frontend.listener.adapter.fragment.project.ButtonSeriesListener;

public class ProjectAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private final AppCompatActivity activity;
    private final List<ProjectModel> data;

    public ProjectAdapter(AppCompatActivity activity, List<ProjectModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list_project, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ProjectModel model = data.get(position);

        Glide.with(activity)
                .load(model.getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(holder.getIvThumbnail());

        holder.getTvTitle().setText(model.getTitle());
        holder.getTvType().setText(model.getType());
        holder.getBtnChapter().setText(model.getChapter().getName());

        holder.getBtnSeries().setOnClickListener(new ButtonSeriesListener(activity, model));
        holder.getBtnChapter().setOnClickListener(new ButtonChapterListener(activity, model));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
