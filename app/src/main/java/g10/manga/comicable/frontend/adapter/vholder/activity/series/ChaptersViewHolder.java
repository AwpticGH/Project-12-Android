package g10.manga.comicable.frontend.adapter.vholder.activity.series;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;

public class ChaptersViewHolder extends RecyclerView.ViewHolder {

    private AppCompatButton button;

    public ChaptersViewHolder(@NonNull View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.button_chapter_activity_series);
    }

    public AppCompatButton getButton() {
        return button;
    }
}
