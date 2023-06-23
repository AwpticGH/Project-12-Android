package g10.manga.comicable.backend.api.model.chapter;

import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;

public class DataModel extends BaseModel {

    private String title;
    private List<String> images;
    private PaginationModel pagination;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public PaginationModel getPagination() {
        return pagination;
    }

    public void setPagination(PaginationModel pagination) {
        this.pagination = pagination;
    }
}
