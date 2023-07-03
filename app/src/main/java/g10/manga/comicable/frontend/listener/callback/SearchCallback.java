package g10.manga.comicable.frontend.listener.callback;

import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.SearchCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import g10.manga.comicable.backend.api.model.search.PaginationModel;
import g10.manga.comicable.backend.api.model.search.SearchModel;
import g10.manga.comicable.dictionary.app.ToastDictionary;
import g10.manga.comicable.flag.api.ResponseFlag;
import g10.manga.comicable.flag.api.search.PaginationFlag;
import g10.manga.comicable.flag.api.search.SearchFlag;
import g10.manga.comicable.frontend.adapter.fragment.search.SearchAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.adapter.fragment.search.SpinnerListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCallback<T> extends BaseListener implements Callback<T> {

    private final SearchCall searchCall;
    private final ContentLoadingProgressBar progressBar;
    private final RecyclerView rvSearch;
    private final AppCompatTextView tvResult;
    private final AppCompatSpinner spinner;
    private SpinnerListener spinnerListener;

    public SearchCallback(AppCompatActivity activity, SearchCall searchCall) {
        super(activity);
        this.searchCall = searchCall;
        progressBar = activity.findViewById(R.id.pb_fragment_search);
        rvSearch = activity.findViewById(R.id.rv_search_fragment_search);
        tvResult = activity.findViewById(R.id.tv_result_fragment_search);
        spinner = activity.findViewById(R.id.spinner_fragment_search);
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        ResponseModel<DataModel> responseModel = null;
        try {
            responseModel = (ResponseModel<DataModel>) response.body();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
            ToastHelper.unknownError(activity).show();
        }
        finally {
            if (responseModel != null) {
                if (ResponseFlag.isSuccessful(responseModel) || ResponseFlag.isPartiallySuccessful(responseModel)) {
                    rvSearch.setHasFixedSize(true);
                    rvSearch.setLayoutManager(new LinearLayoutManager(activity));

                    if (SearchFlag.isEmpty(responseModel.getData())) {
                        tvResult.setText(activity.getResources().getString(R.string.hint_search_failed_fragment_search));
                    }
                    else {
                        tvResult.setText(activity.getResources().getString(R.string.hint_search_success_fragment_search));

                        initSearchResult(responseModel.getData().getSearches());
                        rvSearch.setVisibility(View.VISIBLE);

                        if (!PaginationFlag.isEmpty(responseModel.getData())) {
                            initSpinner(responseModel.getData().getPagination());
                        }
                        if (spinner.getVisibility() == View.INVISIBLE) {
                            spinner.setVisibility(View.VISIBLE);
                        }
                    }
                    tvResult.setVisibility(View.VISIBLE);
                }
                if (ResponseFlag.isSuccessful(responseModel)) {
                    ToastHelper.apiSuccessful(activity).show();
                }
                else if (ResponseFlag.isPartiallySuccessful(responseModel)) {
                    ToastHelper.apiPartiallySuccessful(activity).show();
                }
                else if (ResponseFlag.isFailed(responseModel)) {
                    ToastHelper.apiFailed(activity).show();

                    tvResult.setText(activity.getResources().getString(R.string.hint_search_failed_fragment_search));
                    tvResult.setVisibility(View.VISIBLE);
                    rvSearch.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                }
            }
            else {
                ToastHelper.unknownError(activity).show();

                tvResult.setText(ToastDictionary.UNKNOWN_ERROR);
                tvResult.setVisibility(View.VISIBLE);
                rvSearch.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
            }
            progressBar.hide();
            // TODO : Set window to be intractable again (onResponse)
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        progressBar.hide();
        // TODO : Set window to be intractable again (onFailure)

        ToastHelper.networkError(activity).show();

        tvResult.setText(ToastDictionary.NETWORK_ERROR);
        tvResult.setVisibility(View.VISIBLE);
        rvSearch.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);
    }

    private void initSearchResult(List<SearchModel> models) {
        SearchAdapter adapter = new SearchAdapter(activity, models);
        rvSearch.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initSpinner(List<PaginationModel> models) {
        int size = models.size();
        String[] pages = new String[size + 1];
        pages[0] = "Page";
        for (int i = 0; i < size; i++) {
            pages[i + 1] = models.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, pages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if (spinnerListener == null) {
            try {
                spinnerListener = new SpinnerListener(activity, searchCall, (SearchCallback<ResponseModel<DataModel>>) this, progressBar);
            }
            catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
        spinner.setOnItemSelectedListener(spinnerListener);
    }
}
