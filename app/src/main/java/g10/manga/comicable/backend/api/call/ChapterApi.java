package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.interfaces.call.ChapterGet;

public class ChapterApi<T extends BaseInterface> extends BaseApi<T> {

    public ChapterApi(Class<T> myInterface) {
        super(myInterface);
    }

    public ChapterGet getApi() {
        return (ChapterGet) super.api;
    }
}