package g10.manga.comicable.backend.api.helper;

public class EndpointHelper {

    public static String parseSeriesEndpointAsSeries(String endpoint) {
        return endpoint.substring(endpoint.lastIndexOf("/") + 1);
    }

    public static String parseChapterEndpointAsChapter(String endpoint) {
        return endpoint.substring(endpoint.lastIndexOf("/") + 1);
    }

    public static String parseChapterEndpointAsSeries(String endpoint) {
        return endpoint.substring(endpoint.lastIndexOf("/series/") + 8, endpoint.lastIndexOf("/"));
    }
}
