package g10.manga.comicable.backend.api.controller.modern;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.call.ProjectCall;
import g10.manga.comicable.backend.api.controller.BaseController;
import g10.manga.comicable.backend.api.interfaces.future.ProjectFuture;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectController extends BaseController implements ProjectFuture {

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<ResponseModel<DataModel>> get(String page) {
        CompletableFuture<ResponseModel<DataModel>> future = new CompletableFuture<>();
        ProjectCall<g10.manga.comicable.backend.api.interfaces.call.ProjectCall> projectCall = new ProjectCall<>(g10.manga.comicable.backend.api.interfaces.call.ProjectCall.class);
        Call<ResponseModel<DataModel>> call = projectCall.getApi().get(page);
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
