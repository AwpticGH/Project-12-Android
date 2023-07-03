package g10.manga.comicable.flag.backend.api.project;

import g10.manga.comicable.backend.api.model.project.DataModel;

public class ProjectFlag {

    public static boolean isEmpty(DataModel model) {
        return model.getProjects() == null || model.getProjects().isEmpty();
    }
}
