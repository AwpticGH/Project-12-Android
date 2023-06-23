package g10.manga.comicable.dictionary.api;

public class Routes {

    public static final String BASE = "/api";
    public static final String HOME = BASE + "/home";
    public static final String SERIES = BASE + "/series/{" + Paths.SERIES + "}";
    public static final String CHAPTER = BASE + "/series/{" + Paths.SERIES + "}/{" + Paths.CHAPTER + "}";
    public static final String PROJECT = BASE + "/project/page/{" + Paths.PAGE + "}";
    public static final String SEARCH = BASE + "/search/{" + Paths.QUERY + "}";
    public static final String SEARCH_WITH_PAGE = BASE + "/search/{" + Paths.QUERY + "}/page/{" + Paths.PAGE + "}";

}
