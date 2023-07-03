package g10.manga.comicable.frontend.adapter.vholder.fragment.project;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final CardView cvProject;
    private final AppCompatImageView ivThumbnail;
    private final AppCompatTextView tvTitle, tvType;
    private final AppCompatButton btnSeries, btnChapter;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        cvProject = itemView.findViewById(R.id.cv_project);
        ivThumbnail = itemView.findViewById(R.id.iv_thumbnail_cv_project);
        tvTitle = itemView.findViewById(R.id.tv_title_cv_project);
        tvType = itemView.findViewById(R.id.tv_type_cv_project);
        btnSeries = itemView.findViewById(R.id.button_series_cv_project);
        btnChapter = itemView.findViewById(R.id.button_chapter_cv_project);
    }

    public CardView getCvProject() {
        return cvProject;
    }

    public AppCompatImageView getIvThumbnail() {
        return ivThumbnail;
    }

    public AppCompatTextView getTvTitle() {
        return tvTitle;
    }

    public AppCompatTextView getTvType() {
        return tvType;
    }

    public AppCompatButton getBtnSeries() {
        return btnSeries;
    }

    public AppCompatButton getBtnChapter() {
        return btnChapter;
    }
}
