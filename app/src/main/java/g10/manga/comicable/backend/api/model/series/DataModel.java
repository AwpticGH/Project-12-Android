package g10.manga.comicable.backend.api.model.series;

import java.io.Serializable;
import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;

public class DataModel extends BaseModel implements Serializable {

    private SeriesModel detail;
    private List<ChapterModel> chapters;

    public SeriesModel getDetail() {
        return detail;
    }

    public void setDetail(SeriesModel detail) {
        this.detail = detail;
    }

    public List<ChapterModel> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterModel> chapters) {
        this.chapters = chapters;
    }
}
