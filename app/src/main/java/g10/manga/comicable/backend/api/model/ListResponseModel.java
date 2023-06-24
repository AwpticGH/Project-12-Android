package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import g10.manga.comicable.backend.app.model.manga.ListModelOld;

public class ListResponseModel extends ResponseModel {

    @SerializedName("data")
    private List<ListModelOld> lists;

    public List<ListModelOld> getLists() {
        return lists;
    }
}
