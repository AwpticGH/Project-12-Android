package g10.manga.comicable.frontend.adapter.vholder.fragment.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class SliderViewHolder extends RecyclerView.ViewHolder {

    private final View itemView;
    private final AppCompatImageView ivSlider;

    public SliderViewHolder(@NonNull View itemView) {
        super(itemView);

        this.itemView = itemView;
        this.ivSlider = itemView.findViewById(R.id.iv_slider);
    }

    public View getItemView() {
        return itemView;
    }

    public AppCompatImageView getIvSlider() {
        return ivSlider;
    }
}
