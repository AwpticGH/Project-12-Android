package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.interfaces.call.HomeGet;

public class HomeApi<T extends BaseInterface> extends BaseApi<T> {

    public HomeApi(Class<T> myInterface) {
        super(myInterface);
    }

    public HomeGet getApi() {
        return (HomeGet) super.api;
    }
}
