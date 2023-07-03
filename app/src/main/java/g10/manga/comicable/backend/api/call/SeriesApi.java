package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.interfaces.call.SeriesGet;

public class SeriesApi<T extends BaseInterface> extends BaseApi<T> {
    public SeriesApi(Class<T> myInterface) {
        super(myInterface);
    }

    public SeriesGet getApi() {
        return (SeriesGet) super.api;
    }
}
