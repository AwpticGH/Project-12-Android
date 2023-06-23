package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import g10.manga.comicable.backend.app.model.manga.InfoModel;

public class InfoResponseModel extends ResponseModel {

    @SerializedName("data")
    private InfoModel info;

    public InfoModel getInfo() {
        return info;
    }
}
