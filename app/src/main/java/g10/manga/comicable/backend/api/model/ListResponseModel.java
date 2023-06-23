package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import g10.manga.comicable.backend.app.model.manga.ListModel;

public class ListResponseModel extends ResponseModel {

    @SerializedName("data")
    private List<ListModel> lists;

    public List<ListModel> getLists() {
        return lists;
    }
}
