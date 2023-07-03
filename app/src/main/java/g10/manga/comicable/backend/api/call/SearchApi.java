package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.interfaces.call.SearchGet;

public class SearchApi<T extends BaseInterface> extends BaseApi<T> {
    public SearchApi(Class<T> myInterface) {
        super(myInterface);
    }

    public SearchGet getApi() {
        return (SearchGet) super.api;
    }
}
