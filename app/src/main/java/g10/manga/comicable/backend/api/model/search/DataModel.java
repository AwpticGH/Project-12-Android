package g10.manga.comicable.backend.api.model.search;

import java.io.Serializable;
import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;

public class DataModel extends BaseModel implements Serializable {

    private List<SearchModel> searches;
    private List<PaginationModel> pagination;

    public List<SearchModel> getSearches() {
        return searches;
    }

    public void setSearches(List<SearchModel> searches) {
        this.searches = searches;
    }

    public List<PaginationModel> getPagination() {
        return pagination;
    }

    public void setPagination(List<PaginationModel> pagination) {
        this.pagination = pagination;
    }
}
