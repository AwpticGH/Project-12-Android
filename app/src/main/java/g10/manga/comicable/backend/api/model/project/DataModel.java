package g10.manga.comicable.backend.api.model.project;

import java.util.List;

import g10.manga.comicable.backend.api.model.BaseModel;

public class DataModel extends BaseModel {

    private List<ProjectModel> projects;
    private List<PaginationModel> pagination;

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }

    public List<PaginationModel> getPagination() {
        return pagination;
    }

    public void setPagination(List<PaginationModel> pagination) {
        this.pagination = pagination;
    }
}
