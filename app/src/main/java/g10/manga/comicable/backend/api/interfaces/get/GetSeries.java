package g10.manga.comicable.backend.api.interfaces.get;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;

public interface GetSeries {

    ResponseModel<DataModel> get(String series);
}
