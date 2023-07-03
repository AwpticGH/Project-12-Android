package g10.manga.comicable.backend.api.controller.original;

import g10.manga.comicable.backend.api.call.HomeApi;
import g10.manga.comicable.backend.api.interfaces.call.HomeGet;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;
import retrofit2.Call;

public class HomeCall implements HomeGet {

    @Override
    public Call<ResponseModel<DataModel>> get() {
        HomeApi<HomeGet> api =  new HomeApi<>(HomeGet.class);
        return api.getApi().get();
    }
}
