package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import g10.manga.comicable.backend.app.model.manga.RecommendedModel;

public class RecommendedResponseModel extends ResponseModel {

    @SerializedName("data") private List<RecommendedModel> recommendeds;

    public List<RecommendedModel> getRecommendeds() {
        return recommendeds;
    }
}
