package g10.manga.comicable.backend.api.model.project;

import java.io.Serializable;

public class ProjectModel implements Serializable {

    private String title;
    private String type;
    private String thumbnail;
    private String series;
    private ChapterModel chapter;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public ChapterModel getChapter() {
        return chapter;
    }

    public void setChapter(ChapterModel chapter) {
        this.chapter = chapter;
    }
}
