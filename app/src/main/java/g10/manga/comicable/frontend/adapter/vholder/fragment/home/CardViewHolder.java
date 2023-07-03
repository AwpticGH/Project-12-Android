package g10.manga.comicable.frontend.adapter.vholder.fragment.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final CardView cardView;
    private final ImageView imageView;
    private final TextView tvTitle;
    private final TextView tvType;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView = itemView.findViewById(R.id.cv_home);
        this.imageView = itemView.findViewById(R.id.iv_home_thumbnail);
        this.tvTitle = itemView.findViewById(R.id.tv_home_title);
        this.tvType = itemView.findViewById(R.id.tv_home_type);
    }

    public CardView getCardView() {
        return cardView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvType() {
        return tvType;
    }
}
