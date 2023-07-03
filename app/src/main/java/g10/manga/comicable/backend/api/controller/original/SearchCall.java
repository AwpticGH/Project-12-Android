package g10.manga.comicable.backend.api.controller.original;

import androidx.annotation.Nullable;

import g10.manga.comicable.backend.api.call.SearchApi;
import g10.manga.comicable.backend.api.interfaces.call.SearchGet;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import retrofit2.Call;

public class SearchCall implements SearchGet {

    private final SearchApi<SearchGet> api;
    public SearchCall() {
        api = new SearchApi<>(SearchGet.class);
    }

    @Override
    public Call<ResponseModel<DataModel>> get(String query) {
        return api.getApi().get(query);
    }

    @Override
    public Call<ResponseModel<DataModel>> get(String query, @Nullable String page) {
        return api.getApi().get(query, page);
    }
}
