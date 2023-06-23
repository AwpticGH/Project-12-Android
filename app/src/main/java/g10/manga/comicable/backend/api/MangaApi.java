package g10.manga.comicable.backend.api;

import g10.manga.comicable.backend.api.model.ChapterResponseModel;
import g10.manga.comicable.backend.api.model.InfoResponseModel;
import g10.manga.comicable.backend.api.model.ListResponseModel;
import g10.manga.comicable.backend.api.model.PopularResponseModel;
import g10.manga.comicable.backend.api.model.RecommendedResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MangaApi {

    // Get All Comics
    @GET("list")
    Call<ListResponseModel> getAllComics();

    @GET("list")
    Call<ListResponseModel> getAllComicsWithFilter(@Query("filter")String filter);

    // Get Popular Comics
    @GET("popular/page/{pageNumber}")
    Call<PopularResponseModel> getPopularComics(@Path("pageNumber") int pageNumber);

    // Get Recommended Comics
    @GET("recommended/page/{pageNumber}")
    Call<RecommendedResponseModel> getRecommendedComics(@Path("pageNumber") int pageNumber);

    // Get Comic Info
    @GET("info{endpoint}")
    Call<InfoResponseModel> getComicInfo(@Path(value = "endpoint", encoded = true) String infoEndpoint);

    // Get Chapter Detail
    @GET("chapter{endpoint}")
    Call<ChapterResponseModel> getChapterDetail(@Path(value = "endpoint", encoded = true) String chapterEndpoint);
}
