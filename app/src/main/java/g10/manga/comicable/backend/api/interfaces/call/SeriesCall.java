package g10.manga.comicable.backend.api.interfaces.call;

import g10.manga.comicable.dictionary.api.Paths;
import g10.manga.comicable.dictionary.api.Routes;
import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SeriesCall extends BaseInterface {

    @GET(Routes.SERIES)
    Call<ResponseModel<DataModel>> get(@Path(Paths.SERIES) String series);
}
