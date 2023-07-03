package g10.manga.comicable.frontend.adapter.vholder.fragment.collection;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final ConstraintLayout constraintLayout;
    private final AppCompatImageView ivThumbnail;
    private final AppCompatTextView tvTitle, tvCheckpoint;
    private final AppCompatButton btnCheckpoint;
    private final ContentLoadingProgressBar progressBar;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        constraintLayout = itemView.findViewById(R.id.cl_cv_collection);
        ivThumbnail = itemView.findViewById(R.id.iv_thumbnail_cv_collection);
        tvTitle = itemView.findViewById(R.id.tv_title_cv_collection);
        tvCheckpoint = itemView.findViewById(R.id.tv_checkpoint_cv_collection);
        btnCheckpoint = itemView.findViewById(R.id.button_checkpoint_cv_collection);
        progressBar = itemView.findViewById(R.id.pb_cv_collection);
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public AppCompatImageView getIvThumbnail() {
        return ivThumbnail;
    }

    public AppCompatTextView getTvTitle() {
        return tvTitle;
    }

    public AppCompatTextView getTvCheckpoint() {
        return tvCheckpoint;
    }

    public AppCompatButton getBtnCheckpoint() {
        return btnCheckpoint;
    }

    public ContentLoadingProgressBar getProgressBar() {
        return progressBar;
    }
}
