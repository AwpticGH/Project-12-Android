package g10.manga.comicable.backend.api.controller.traditional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import g10.manga.comicable.backend.api.call.HomeApi;
import g10.manga.comicable.backend.api.interfaces.call.HomeGet;
import g10.manga.comicable.backend.api.interfaces.get.GetHome;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;
import retrofit2.Call;
import retrofit2.Response;

public class HomeController extends BaseController implements GetHome {
    @Override
    public ResponseModel<DataModel> get() {
        Future<ResponseModel<DataModel>> future = executorService.submit(() -> {
            HomeApi<HomeGet> mCall = new HomeApi<>(HomeGet.class);
            Call<ResponseModel<DataModel>> call = mCall.getApi().get();
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
            shutdown();
        }

        return result;
    }
}
