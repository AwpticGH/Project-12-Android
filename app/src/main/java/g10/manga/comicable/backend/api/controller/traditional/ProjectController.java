package g10.manga.comicable.backend.api.controller.traditional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import g10.manga.comicable.backend.api.call.ProjectApi;
import g10.manga.comicable.backend.api.interfaces.call.ProjectGet;
import g10.manga.comicable.backend.api.interfaces.get.GetProject;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import retrofit2.Call;
import retrofit2.Response;

public class ProjectController extends BaseController implements GetProject {
    @Override
    public ResponseModel<DataModel> get(String page) {
        Future<ResponseModel<DataModel>> future = executorService.submit(() -> {
            ProjectApi<ProjectGet> mCall = new ProjectApi<>(ProjectGet.class);
            Call<ResponseModel<g10.manga.comicable.backend.api.model.project.DataModel>> call = mCall.getApi().get(page);
            Response<ResponseModel<g10.manga.comicable.backend.api.model.project.DataModel>> response = call.execute();
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
