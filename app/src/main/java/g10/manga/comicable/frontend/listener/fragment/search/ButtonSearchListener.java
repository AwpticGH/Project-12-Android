package g10.manga.comicable.frontend.listener.fragment.search;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.ContentLoadingProgressBar;

import java.util.Objects;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.SearchCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import g10.manga.comicable.dictionary.app.IntentDictionary;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.callback.SearchCallback;

public class ButtonSearchListener extends BaseListener implements View.OnClickListener {

    public ButtonSearchListener(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onClick(View view) {
        ContentLoadingProgressBar progressBar = activity.findViewById(R.id.pb_fragment_search);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.show();
        // TODO : Set window to not be intractable

        AppCompatEditText etSearch = activity.findViewById(R.id.et_search_fragment_search);
        String query = Objects.requireNonNull(etSearch.getText()).toString().trim();

        SearchCall searchCall = new SearchCall();
        SearchCallback<ResponseModel<DataModel>> searchCallback = new SearchCallback<>(activity, searchCall);
        searchCall.get(query).enqueue(searchCallback);
    }
}
