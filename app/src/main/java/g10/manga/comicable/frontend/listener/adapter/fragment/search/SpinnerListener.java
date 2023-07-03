package g10.manga.comicable.frontend.listener.adapter.fragment.search;

import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.ContentLoadingProgressBar;

import java.util.Objects;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.SearchCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.callback.SearchCallback;

public class SpinnerListener extends BaseListener implements AdapterView.OnItemSelectedListener {

    private final SearchCall searchCall;
    private final SearchCallback<ResponseModel<DataModel>> searchCallback;
    private final ContentLoadingProgressBar progressBar;

    public SpinnerListener(
            AppCompatActivity activity,
            SearchCall searchCall,
            SearchCallback<ResponseModel<DataModel>> searchCallback,
            ContentLoadingProgressBar progressBar
    ) {
        super(activity);
        this.searchCall = searchCall;
        this.searchCallback = searchCallback;
        this.progressBar = progressBar;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!adapterView.getSelectedItem().equals("Page")) {
            progressBar.show();
            AppCompatEditText etSearch = activity.findViewById(R.id.et_search_fragment_search);
            String query = Objects.requireNonNull(etSearch.getText()).toString().trim();
            String page = adapterView.getItemAtPosition(i).toString();
            searchCall.get(query, page).enqueue(searchCallback);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing?
    }
}
