package g10.manga.comicable.frontend.listener.callback.fragment.home;

import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.islamkhsh.CardSliderViewPager;

import java.util.ArrayList;
import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;
import g10.manga.comicable.backend.api.model.home.HomeModel;
import g10.manga.comicable.backend.app.model.SliderModel;
import g10.manga.comicable.flag.backend.api.ResponseFlag;
import g10.manga.comicable.frontend.adapter.fragment.home.SliderAdapter;
import g10.manga.comicable.frontend.adapter.fragment.home.HomeAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeCallback<T> extends BaseListener implements Callback<T> {

    private final ProgressBar pbTrending, pbLatest, pbMirror;
    private RecyclerView rvTrending, rvLatest, rvMirror;
    private HomeAdapter trendingAdapter, latestAdapter, mirrorAdapter;

    public HomeCallback(AppCompatActivity activity) {
        super(activity);
        pbTrending = activity.findViewById(R.id.pb_trending_fragment_home);
        pbLatest = activity.findViewById(R.id.pb_latest_fragment_home);
        pbMirror = activity.findViewById(R.id.pb_mirror_fragment_home);
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        ResponseModel<DataModel> responseModel = null;
        try {
            responseModel = (ResponseModel<DataModel>) response.body();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
        finally {
            if (responseModel != null) {
                pbTrending.setVisibility(View.GONE);
                pbLatest.setVisibility(View.GONE);
                pbMirror.setVisibility(View.GONE);

                rvTrending = activity.findViewById(R.id.rv_trending_fragment_home);
                rvTrending.setHasFixedSize(true);
                rvTrending.setLayoutManager(new LinearLayoutManager(activity));

                rvLatest = activity.findViewById(R.id.rv_latest_fragment_home);
                rvLatest.setHasFixedSize(true);
                rvLatest.setLayoutManager(new LinearLayoutManager(activity));

                rvMirror = activity.findViewById(R.id.rv_mirror_fragment_home);
                rvMirror.setHasFixedSize(true);
                rvMirror.setLayoutManager(new LinearLayoutManager(activity));

                if (ResponseFlag.isSuccessful(responseModel)) {
                    ToastHelper.apiSuccessful(activity).show();


                    initCardViewSlider(responseModel.getData());
                    initRecyclerViewTrending(responseModel.getData());
                    initRecyclerViewLatest(responseModel.getData());
                    initRecyclerViewMirror(responseModel.getData());
                }
                else if (ResponseFlag.isPartiallySuccessful(responseModel)) {
                    ToastHelper.apiPartiallySuccessful(activity).show();

                    if (responseModel.getData().getTrending() != null) {
                        initCardViewSlider(responseModel.getData());
                        initRecyclerViewTrending(responseModel.getData());
                    }
                    if (responseModel.getData().getLatest() != null) {
                        initRecyclerViewLatest(responseModel.getData());
                    }
                    if (responseModel.getData().getMirror() != null) {
                        initRecyclerViewMirror(responseModel.getData());
                    }
                }
                else if (ResponseFlag.isFailed(responseModel)) {
                    ToastHelper.apiFailed(activity).show();
                }
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        ToastHelper.apiFailed(activity).show();
    }

    private void initCardViewSlider(DataModel model) {
        List<SliderModel> sliderModels = new ArrayList<>();
        for (HomeModel data : model.getTrending()) {
            SliderModel sliderModel = new SliderModel();
            sliderModel.setThumbnail(data.getThumbnail());
            sliderModels.add(sliderModel);
        }

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModels);
        CardSliderViewPager cardSliderViewPager = activity.findViewById(R.id.card_slider_view_pager_home_header);
        cardSliderViewPager.setAdapter(sliderAdapter);
    }

    private void initRecyclerViewTrending(DataModel model) {
        if (trendingAdapter == null) {
            trendingAdapter = new HomeAdapter((AppCompatActivity) activity, model.getTrending());
            rvTrending.setAdapter(trendingAdapter);
            trendingAdapter.notifyDataSetChanged();
        }
    }

    private void initRecyclerViewLatest(DataModel model) {
        if (latestAdapter == null) {
            latestAdapter = new HomeAdapter((AppCompatActivity) activity, model.getLatest());
            rvLatest.setAdapter(latestAdapter);
            latestAdapter.notifyDataSetChanged();
        }
    }

    private void initRecyclerViewMirror(DataModel model) {
        if (mirrorAdapter == null) {
            mirrorAdapter = new HomeAdapter((AppCompatActivity) activity, model.getMirror());
            rvMirror.setAdapter(mirrorAdapter);
            mirrorAdapter.notifyDataSetChanged();
        }
    }
}
