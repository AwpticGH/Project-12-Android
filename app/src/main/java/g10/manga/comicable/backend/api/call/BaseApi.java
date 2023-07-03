package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.helper.RetrofitHelper;
import g10.manga.comicable.backend.api.interfaces.BaseInterface;

public class BaseApi<T extends BaseInterface> {

    protected BaseInterface api;

    protected BaseApi(Class<T> myInterface) {
        api = RetrofitHelper.getInstance().create(myInterface);
    }
}
