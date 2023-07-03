package g10.manga.comicable.backend.api.controller.original;

import g10.manga.comicable.backend.api.model.BaseModel;
import g10.manga.comicable.backend.api.model.ResponseModel;
import retrofit2.Call;

public class BaseCall<T extends BaseModel> {

    protected Class<T> clazz;

    protected BaseCall(Class<T> clazz) {
        this.clazz = clazz;
    }
}
