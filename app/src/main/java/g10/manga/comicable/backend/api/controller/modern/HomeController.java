package g10.manga.comicable.backend.api.controller.modern;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.call.HomeCall;
import g10.manga.comicable.backend.api.controller.BaseController;
import g10.manga.comicable.backend.api.interfaces.future.HomeFuture;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeController extends BaseController implements HomeFuture {

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<ResponseModel<DataModel>> get() {
        CompletableFuture<ResponseModel<DataModel>> future = new CompletableFuture<>();
        HomeCall<g10.manga.comicable.backend.api.interfaces.call.HomeCall> homeCall = new HomeCall<>(g10.manga.comicable.backend.api.interfaces.call.HomeCall.class);
        Call<ResponseModel<DataModel>> call = homeCall.getApi().get();
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
