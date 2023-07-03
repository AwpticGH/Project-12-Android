package g10.manga.comicable.frontend.adapter.fragment.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.github.islamkhsh.CardSliderAdapter;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.SliderModel;
import g10.manga.comicable.frontend.adapter.vholder.fragment.home.SliderViewHolder;

public class SliderAdapter extends CardSliderAdapter<SliderViewHolder> {

    private final List<SliderModel> models;

    public SliderAdapter(List<SliderModel> models){
        this.models = models;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_slider_home, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void bindVH(SliderViewHolder viewHolder, int position) {
        Glide.with(viewHolder.getItemView())
                .load(models.get(position).getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(viewHolder.getIvSlider());
    }

    @Override
    public int getItemCount(){
        return models.size();
    }
}