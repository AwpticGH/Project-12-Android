package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;

public class ChapterCall<T extends BaseInterface> extends BaseCall<T> {

    public ChapterCall(Class<T> myInterface) {
        super(myInterface);
    }

    public g10.manga.comicable.backend.api.interfaces.call.ChapterCall getApi() {
        return (g10.manga.comicable.backend.api.interfaces.call.ChapterCall) super.api;
    }
}