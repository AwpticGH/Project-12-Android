package g10.manga.comicable.backend.api.interfaces.get;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;

public interface GetHome {

    ResponseModel<DataModel> get();
}
