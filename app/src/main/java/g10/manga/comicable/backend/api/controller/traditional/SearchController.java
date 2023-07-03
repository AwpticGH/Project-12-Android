package g10.manga.comicable.backend.api.controller.traditional;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import g10.manga.comicable.backend.api.call.SearchApi;
import g10.manga.comicable.backend.api.interfaces.call.SearchGet;
import g10.manga.comicable.backend.api.interfaces.get.GetSearch;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import retrofit2.Call;
import retrofit2.Response;

public class SearchController extends BaseController implements GetSearch {

    @Override
    public ResponseModel<DataModel> get(String query, @Nullable String page) {
        Future<ResponseModel<DataModel>> future = executorService.submit(() -> {
            SearchApi<SearchGet> mCall = new SearchApi<>(SearchGet.class);
            Call<ResponseModel<DataModel>> call;
            call = mCall.getApi().get(query, page);
            Response<ResponseModel<DataModel>> response = call.execute();
            return response.body();
        });

        ResponseModel<DataModel> result = null;
        try {
            result = future.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            executorService.shutdown();
        }

        return result;
    }
}
