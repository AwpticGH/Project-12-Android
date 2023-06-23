package g10.manga.comicable.backend.api.interfaces.call;

import g10.manga.comicable.dictionary.api.Routes;
import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeCall extends BaseInterface {

    @GET(Routes.HOME)
    Call<ResponseModel<DataModel>> get();

}
