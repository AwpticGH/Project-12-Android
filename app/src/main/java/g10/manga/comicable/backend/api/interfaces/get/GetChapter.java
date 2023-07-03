package g10.manga.comicable.backend.api.interfaces.get;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;

public interface GetChapter {

    ResponseModel<DataModel> get(String series, String chapter);

}
