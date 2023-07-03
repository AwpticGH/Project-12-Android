package g10.manga.comicable.frontend.adapter.vholder.fragment.search;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final CardView cvSearch;
    private final AppCompatImageView ivThumbnail;
    private final AppCompatTextView tvTitle, tvStatus, tvRelease, tvRating, tvGenre;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        cvSearch = itemView.findViewById(R.id.cv_search);
        ivThumbnail = itemView.findViewById(R.id.iv_thumbnail_cv_search);
        tvTitle = itemView.findViewById(R.id.tv_title_cv_search);
        tvStatus = itemView.findViewById(R.id.tv_status_cv_search);
        tvRelease = itemView.findViewById(R.id.tv_release_cv_search);
        tvRating = itemView.findViewById(R.id.tv_rating_cv_search);
        tvGenre = itemView.findViewById(R.id.tv_genre_cv_search);
    }

    public CardView getCvSearch() {
        return cvSearch;
    }

    public AppCompatImageView getIvThumbnail() {
        return ivThumbnail;
    }

    public AppCompatTextView getTvTitle() {
        return tvTitle;
    }

    public AppCompatTextView getTvStatus() {
        return tvStatus;
    }

    public AppCompatTextView getTvRelease() {
        return tvRelease;
    }

    public AppCompatTextView getTvRating() {
        return tvRating;
    }

    public AppCompatTextView getTvGenre() {
        return tvGenre;
    }
}
