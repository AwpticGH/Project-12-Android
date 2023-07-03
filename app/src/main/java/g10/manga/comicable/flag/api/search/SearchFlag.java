package g10.manga.comicable.flag.api.search;

import java.util.List;

import g10.manga.comicable.backend.api.model.search.DataModel;

public class SearchFlag {

    public static boolean isEmpty(DataModel model) {
        return model.getSearches() == null || model.getSearches().isEmpty();
    }
}
