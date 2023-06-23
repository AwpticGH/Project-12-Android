package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;

public class SeriesCall<T extends BaseInterface> extends BaseCall<T> {
    public SeriesCall(Class<T> myInterface) {
        super(myInterface);
    }

    public g10.manga.comicable.backend.api.interfaces.call.SeriesCall getApi() {
        return (g10.manga.comicable.backend.api.interfaces.call.SeriesCall) super.api;
    }
}
