package g10.manga.comicable.backend.api.interfaces.get;

import androidx.annotation.Nullable;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;

public interface GetSearch {

    ResponseModel<DataModel> get(String query, @Nullable String page);
}
