package g10.manga.comicable.flag.api.search;

import g10.manga.comicable.backend.api.model.search.DataModel;

public class PaginationFlag {

    public static boolean isEmpty(DataModel model) {
        return model.getPagination() == null || model.getPagination().isEmpty();
    }
}
