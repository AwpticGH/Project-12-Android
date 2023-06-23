package g10.manga.comicable.backend.api.controller.modern;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.call.SeriesCall;
import g10.manga.comicable.backend.api.controller.BaseController;
import g10.manga.comicable.backend.api.interfaces.future.SeriesFuture;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesController extends BaseController implements SeriesFuture {

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<ResponseModel<DataModel>> get(String series) {
        CompletableFuture<ResponseModel<DataModel>> future = new CompletableFuture<>();
        SeriesCall<g10.manga.comicable.backend.api.interfaces.call.SeriesCall> seriesCall = new SeriesCall<>(g10.manga.comicable.backend.api.interfaces.call.SeriesCall.class);
        Call<ResponseModel<DataModel>> call = seriesCall.getApi().get(series);
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
