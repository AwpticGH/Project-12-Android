package g10.manga.comicable.backend.api.model.search;

import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;
import g10.manga.comicable.backend.api.model.project.ProjectModel;

public class DataModel extends BaseModel {

    private List<ProjectModel> searches;
    private List<PaginationModel> pagination;

    public List<ProjectModel> getSearches() {
        return searches;
    }

    public void setSearches(List<ProjectModel> searches) {
        this.searches = searches;
    }

    public List<PaginationModel> getPagination() {
        return pagination;
    }

    public void setPagination(List<PaginationModel> pagination) {
        this.pagination = pagination;
    }
}
