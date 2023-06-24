package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import g10.manga.comicable.backend.app.model.manga.RecommendedModelOld;

public class RecommendedResponseModel extends ResponseModel {

    @SerializedName("data") private List<RecommendedModelOld> recommendeds;

    public List<RecommendedModelOld> getRecommendeds() {
        return recommendeds;
    }
}
