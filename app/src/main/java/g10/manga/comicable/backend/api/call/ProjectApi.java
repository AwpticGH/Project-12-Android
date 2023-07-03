package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.interfaces.call.ProjectGet;

public class ProjectApi<T extends BaseInterface> extends BaseApi<T> {
    public ProjectApi(Class<T> myInterface) {
        super(myInterface);
    }

    public ProjectGet getApi() {
        return (ProjectGet) super.api;
    }
}
