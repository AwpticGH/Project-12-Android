package g10.manga.comicable.backend.api.controller.traditional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import g10.manga.comicable.backend.api.call.SeriesApi;
import g10.manga.comicable.backend.api.interfaces.call.SeriesGet;
import g10.manga.comicable.backend.api.interfaces.get.GetSeries;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import retrofit2.Call;
import retrofit2.Response;

public class SeriesController extends BaseController implements GetSeries {
    @Override
    public ResponseModel<DataModel> get(String series) {
        Future<ResponseModel<DataModel>> future = executorService.submit(() -> {
            SeriesApi<SeriesGet> mCall = new SeriesApi<>(SeriesGet.class);
            Call<ResponseModel<DataModel>> call = mCall.getApi().get(series);
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
