package g10.manga.comicable.flag.api.chapter;

import g10.manga.comicable.backend.api.model.chapter.PaginationModel;

public class PaginationFlag {

    public static boolean hasNext(PaginationModel model) {
        return model.getNext() != null && (!model.getNext().isEmpty() || !model.getNext().isBlank());
    }

    public static boolean hasPrevious(PaginationModel model) {
        return model.getPrevious() != null && (!model.getPrevious().isEmpty() || !model.getPrevious().isBlank());
    }
}
