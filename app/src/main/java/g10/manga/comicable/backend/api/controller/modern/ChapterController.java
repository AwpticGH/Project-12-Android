package g10.manga.comicable.backend.api.controller.modern;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.controller.BaseController;
import g10.manga.comicable.backend.api.interfaces.call.ChapterCall;
import g10.manga.comicable.backend.api.interfaces.future.ChapterFuture;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterController extends BaseController implements ChapterFuture {

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<ResponseModel<DataModel>> get(String series, String chapter) {
        CompletableFuture<ResponseModel<DataModel>> future = new CompletableFuture<>();
        g10.manga.comicable.backend.api.call.ChapterCall<ChapterCall> chapterCall = new g10.manga.comicable.backend.api.call.ChapterCall<>(ChapterCall.class);
        Call<ResponseModel<DataModel>> call = chapterCall.getApi().get(series, chapter);
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
