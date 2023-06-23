package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import g10.manga.comicable.backend.app.model.manga.ChapterModel;

public class ChapterResponseModel extends ResponseModel {

    @SerializedName("data")
    private ChapterModel chapter;

    public ChapterModel getChapter() {
        return chapter;
    }
}
