package g10.manga.comicable.frontend.listener.callback;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.ChapterModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import g10.manga.comicable.backend.api.model.series.SeriesModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.flag.api.ResponseFlag;
import g10.manga.comicable.frontend.adapter.activity.series.ChaptersAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesCallback<T> extends BaseListener implements Callback<T> {

    private Toolbar toolbar;
    private RecyclerView rvChapters;
    private ImageView ivThumbnail;
    private TextView tvTitle, tvAlternative, tvType, tvStatus,
            tvAuthor, tvArtist, tvRating, tvRelease, tvGenre, tvSynopsis;

    public SeriesCallback(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        ResponseModel<DataModel> responseModel = null;
        try {
            responseModel = (ResponseModel<DataModel>) response.body();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
            ToastHelper.apiFailed(activity);
        }
        finally {
            if (responseModel != null) {
                if (ResponseFlag.isSuccessful(responseModel) || ResponseFlag.isPartiallySuccessful(responseModel)) {
                    ContentLoadingProgressBar progressBar = activity.findViewById(R.id.pb_activity_series);
                    progressBar.hide();
                    rvChapters = activity.findViewById(R.id.rv_chapter_activity_series);
                    rvChapters.setHasFixedSize(true);
                    rvChapters.setLayoutManager(new LinearLayoutManager(activity));

                    toolbar = activity.findViewById(R.id.toolbar_activity_series);

                    ivThumbnail = activity.findViewById(R.id.iv_thumbnail_activity_series);

                    tvTitle = activity.findViewById(R.id.tv_title_activity_series);
                    tvAlternative = activity.findViewById(R.id.tv_alternative_activity_series);
                    tvType = activity.findViewById(R.id.tv_type_activity_series);
                    tvStatus = activity.findViewById(R.id.tv_status_activity_series);
                    tvAuthor = activity.findViewById(R.id.tv_author_activity_series);
                    tvArtist = activity.findViewById(R.id.tv_artist_activity_series);
                    tvRating = activity.findViewById(R.id.tv_rating_activity_series);
                    tvRelease = activity.findViewById(R.id.tv_release_activity_series);
                    tvGenre = activity.findViewById(R.id.tv_genre_activity_series);
                    tvSynopsis = activity.findViewById(R.id.tv_synopsis_activity_series);
                }
                if (ResponseFlag.isSuccessful(responseModel)) {
                    ToastHelper.apiSuccessful(activity);

                    initDetail(responseModel.getData().getDetail());
                    initChapters(responseModel.getData().getChapters());
                }
                else if (ResponseFlag.isPartiallySuccessful(responseModel)) {
                    ToastHelper.apiPartiallySuccessful(activity);

                    if (responseModel.getData().getDetail() != null) {
                        initDetail(responseModel.getData().getDetail());
                    }
                    if (responseModel.getData().getChapters() != null || !responseModel.getData().getChapters().isEmpty()) {
                        initChapters(responseModel.getData().getChapters());
                    }
                }
                else if (ResponseFlag.isFailed(responseModel)) {
                    ToastHelper.apiFailed(activity);
                    activity.finish();
                }
            }
            else {
                ToastHelper.apiFailed(activity);
                activity.finish();
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        ToastHelper.networkError(activity);
        activity.finish();
        throw new RuntimeException(t);
    }

    private void initDetail(SeriesModel model) {
        toolbar.setTitle(model.getTitle());

        Glide.with(activity)
                .load(model.getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(ivThumbnail);

        tvTitle.setText(model.getTitle());
        tvAlternative.setText(model.getAlternative());
        tvType.setText(model.getType());
        tvStatus.setText(model.getStatus());

        tvAuthor.setText(model.getAuthor());
        tvArtist.setText(model.getArtist());
        tvRating.setText(String.format("%s (%s)", model.getRating(), model.getRank()));
        tvRelease.setText(model.getRelease());
        tvGenre.setText(model.getGenres().toString());
        tvSynopsis.setText(model.getSynopsis());

        activity.getIntent().putExtra(IntentDictionary.SERIES_TITLE, model.getTitle());
    }

    private void initChapters(List<ChapterModel> models) {
        ChaptersAdapter chaptersAdapter = new ChaptersAdapter(activity, models);
        rvChapters.setAdapter(chaptersAdapter);
        chaptersAdapter.notifyDataSetChanged();
    }
}
