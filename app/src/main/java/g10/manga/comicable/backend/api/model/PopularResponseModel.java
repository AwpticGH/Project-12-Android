package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import g10.manga.comicable.backend.app.model.manga.PopularModelOld;

public class PopularResponseModel extends ResponseModel {

    @SerializedName("data") private List<PopularModelOld> populars;

    public List<PopularModelOld> getPopulars() {
        return populars;
    }
}
