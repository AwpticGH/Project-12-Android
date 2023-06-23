package g10.manga.comicable.backend.api.interfaces.call;

import g10.manga.comicable.dictionary.api.Paths;
import g10.manga.comicable.dictionary.api.Routes;
import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SearchCall extends BaseInterface {

    @GET(Routes.SEARCH)
    Call<ResponseModel<DataModel>> get(@Path(Paths.QUERY) String query);

    @GET(Routes.SEARCH_WITH_PAGE)
    Call<ResponseModel<DataModel>> get(@Path(Paths.QUERY) String query, @Path(Paths.PAGE) String page);

}
