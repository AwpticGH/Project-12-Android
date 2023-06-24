package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import g10.manga.comicable.backend.app.model.manga.InfoModelOld;

public class InfoResponseModel extends ResponseModel {

    @SerializedName("data")
    private InfoModelOld info;

    public InfoModelOld getInfo() {
        return info;
    }
}
