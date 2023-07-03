package g10.manga.comicable.backend.api.interfaces.get;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;

public interface GetProject {

    ResponseModel<DataModel> get(String page);
}
