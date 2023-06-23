package g10.manga.comicable.backend.api.model.home;

import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;

public class DataModel extends BaseModel {

    private List<HomeModel> trending;
    private List<HomeModel> latest;
    private List<HomeModel> mirror;

    public List<HomeModel> getTrending() {
        return trending;
    }

    public void setTrending(List<HomeModel> trending) {
        this.trending = trending;
    }

    public List<HomeModel> getLatest() {
        return latest;
    }

    public void setLatest(List<HomeModel> latest) {
        this.latest = latest;
    }

    public List<HomeModel> getMirror() {
        return mirror;
    }

    public void setMirror(List<HomeModel> mirror) {
        this.mirror = mirror;
    }
}
