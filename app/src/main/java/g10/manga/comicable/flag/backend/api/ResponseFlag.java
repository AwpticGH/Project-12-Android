package g10.manga.comicable.flag.backend.api;

import g10.manga.comicable.dictionary.api.ResponseMessages;
import g10.manga.comicable.backend.api.model.ResponseModel;

public class ResponseFlag {

    public static boolean isSuccessful(ResponseModel model) {
        return model.getStatus().equals("200") && model.getMessage().equals(ResponseMessages.FULL) && model.getData() != null;
    }

    public static boolean isPartiallySuccessful(ResponseModel model) {
        return model.getStatus().equals("200") && model.getMessage().equals(ResponseMessages.PARTIAL) && model.getData() != null;
    }

    public static boolean isFailed(ResponseModel model) {
        return model.getStatus().equals("404") || model.getMessage().equals(ResponseMessages.FAILED);
    }
}
