package g10.manga.comicable.backend.api.controller.traditional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import g10.manga.comicable.backend.api.call.ChapterApi;
import g10.manga.comicable.backend.api.interfaces.call.ChapterGet;
import g10.manga.comicable.backend.api.interfaces.get.GetChapter;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import retrofit2.Call;
import retrofit2.Response;

public class ChapterController extends BaseController implements GetChapter {

    @Override
    public ResponseModel<DataModel> get(String series, String chapter) {
        Future<ResponseModel<DataModel>> future = executorService.submit(() -> {
            ChapterApi<ChapterGet> mCall = new ChapterApi<>(ChapterGet.class);
            Call<ResponseModel<DataModel>> call = mCall.getApi().get(series, chapter);
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
