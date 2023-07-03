package g10.manga.comicable.frontend.adapter.vholder.activity.chapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class ChapterViewHolder extends RecyclerView.ViewHolder {

    private final AppCompatImageView imageView;

    public ChapterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.iv_chapter_activity_chapter);
    }

    public AppCompatImageView getImageView() {
        return imageView;
    }
}
