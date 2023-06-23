package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;

public class ProjectCall<T extends BaseInterface> extends BaseCall<T> {
    public ProjectCall(Class<T> myInterface) {
        super(myInterface);
    }

    public g10.manga.comicable.backend.api.interfaces.call.ProjectCall getApi() {
        return (g10.manga.comicable.backend.api.interfaces.call.ProjectCall) super.api;
    }
}
