package g10.manga.comicable.backend.api.interfaces.call;

import g10.manga.comicable.dictionary.api.Paths;
import g10.manga.comicable.dictionary.api.Routes;
import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProjectGet extends BaseInterface {

    @GET(Routes.PROJECT)
    Call<ResponseModel<DataModel>> get(@Path(Paths.PAGE) String page);

}
