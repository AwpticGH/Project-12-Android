package g10.manga.comicable.backend.api.controller.original;

import g10.manga.comicable.backend.api.call.ProjectApi;
import g10.manga.comicable.backend.api.interfaces.call.ProjectGet;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import retrofit2.Call;

public class ProjectCall implements ProjectGet {
    @Override
    public Call<ResponseModel<DataModel>> get(String page) {
        ProjectApi<ProjectGet> api = new ProjectApi<>(ProjectGet.class);
        return api.getApi().get(page);
    }
}
