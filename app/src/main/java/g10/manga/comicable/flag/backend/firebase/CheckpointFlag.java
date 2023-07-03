package g10.manga.comicable.flag.backend.firebase;

import android.util.Log;

import g10.manga.comicable.backend.api.helper.EndpointHelper;

public class CheckpointFlag {

    public static boolean isGreater(String val1, String val2) {
        return EndpointHelper.parseChapterEndpointAsInteger(val1) > EndpointHelper.parseChapterEndpointAsInteger(val2);
    }
}
