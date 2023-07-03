package g10.manga.comicable.backend.api.controller.original;

import g10.manga.comicable.backend.api.call.ChapterApi;
import g10.manga.comicable.backend.api.interfaces.call.ChapterGet;
import g10.manga.comicable.backend.api.model.BaseModel;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import retrofit2.Call;
import retrofit2.Callback;

public class ChapterCall implements ChapterGet {

    @Override
    public Call<ResponseModel<DataModel>> get(String series, String chapter) {
        ChapterApi<ChapterGet> api = new ChapterApi<>(ChapterGet.class);
        return api.getApi().get(series, chapter);
    }
}
