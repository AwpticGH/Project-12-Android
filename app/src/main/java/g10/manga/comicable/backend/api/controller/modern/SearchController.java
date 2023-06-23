package g10.manga.comicable.backend.api.controller.modern;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.controller.BaseController;
import g10.manga.comicable.backend.api.call.SearchCall;
import g10.manga.comicable.backend.api.interfaces.future.SearchFuture;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchController extends BaseController implements SearchFuture {
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<ResponseModel<DataModel>> get(String query, @Nullable String page) {
        CompletableFuture<ResponseModel<DataModel>> future = new CompletableFuture<>();
        SearchCall<g10.manga.comicable.backend.api.interfaces.call.SearchCall> searchCall = new SearchCall<>(g10.manga.comicable.backend.api.interfaces.call.SearchCall.class);
        Call<ResponseModel<DataModel>> call;
        if (page == null) {
            call = searchCall.getApi().get(query);
        }
        else {
            call = searchCall.getApi().get(query, page);
        }
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel<DataModel>> call, @NonNull Response<ResponseModel<DataModel>> response) {
                ResponseModel<DataModel> responseModel = response.body();
                assert responseModel != null;
                future.complete(responseModel);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel<DataModel>> call, @NonNull Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }
}
