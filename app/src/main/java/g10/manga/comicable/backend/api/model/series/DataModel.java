package g10.manga.comicable.backend.api.model.series;

import java.io.Serializable;
import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;

public class DataModel extends BaseModel implements Serializable {

    private DetailModel detail;
    private List<ChapterModel> chapters;

    public DetailModel getDetail() {
        return detail;
    }

    public void setDetail(DetailModel detail) {
        this.detail = detail;
    }

    public List<ChapterModel> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterModel> chapters) {
        this.chapters = chapters;
    }
}
