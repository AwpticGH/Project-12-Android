package g10.manga.comicable.backend.api.model;

import com.google.gson.annotations.SerializedName;

import g10.manga.comicable.backend.app.model.manga.ChapterModelOld;

public class ChapterResponseModel extends ResponseModel {

    @SerializedName("data")
    private ChapterModelOld chapter;

    public ChapterModelOld getChapter() {
        return chapter;
    }
}
