package g10.manga.comicable.frontend.adapter.activity.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.model.series.ChapterModel;
import g10.manga.comicable.frontend.adapter.vholder.activity.series.ChaptersViewHolder;
import g10.manga.comicable.frontend.listener.adapter.activity.series.ButtonChapterListener;

public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersViewHolder> {

    private AppCompatActivity activity;
    private List<ChapterModel> data;

    public ChaptersAdapter(AppCompatActivity activity, List<ChapterModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public ChaptersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_list_chapters_activity_series, parent, false);
        return new ChaptersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChaptersViewHolder holder, int position) {
        ChapterModel model = data.get(position);

        holder.getButton().setText(model.getName());
        holder.getButton().setOnClickListener(new ButtonChapterListener(activity, model));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
