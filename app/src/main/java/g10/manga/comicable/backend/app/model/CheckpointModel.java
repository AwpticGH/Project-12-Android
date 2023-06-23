package g10.manga.comicable.backend.app.model;

import java.io.Serializable;

import g10.manga.comicable.backend.app.model.manga.ChapterModel;
import g10.manga.comicable.backend.app.model.manga.PopularModel;

public class CheckpointModel implements Serializable {

    // uid
    private String uid;
    //
    private String collection;
    // Comic chapter
    private String chapter;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
