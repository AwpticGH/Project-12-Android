package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;

public class SearchCall<T extends BaseInterface> extends BaseCall<T> {
    public SearchCall(Class<T> myInterface) {
        super(myInterface);
    }

    public g10.manga.comicable.backend.api.interfaces.call.SearchCall getApi() {
        return (g10.manga.comicable.backend.api.interfaces.call.SearchCall) super.api;
    }
}
