package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;

public class HomeCall<T extends BaseInterface> extends BaseCall<T> {

    public HomeCall(Class<T> myInterface) {
        super(myInterface);
    }

    public g10.manga.comicable.backend.api.interfaces.call.HomeCall getApi() {
        return (g10.manga.comicable.backend.api.interfaces.call.HomeCall) super.api;
    }
}
