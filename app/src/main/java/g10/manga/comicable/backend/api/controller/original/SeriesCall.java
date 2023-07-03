package g10.manga.comicable.backend.api.controller.original;

import g10.manga.comicable.backend.api.call.SeriesApi;
import g10.manga.comicable.backend.api.interfaces.call.SeriesGet;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import retrofit2.Call;

public class SeriesCall implements SeriesGet {
    @Override
    public Call<ResponseModel<DataModel>> get(String series) {
        SeriesApi<SeriesGet> api = new SeriesApi<>(SeriesGet.class);
        return api.getApi().get(series);
    }
}
