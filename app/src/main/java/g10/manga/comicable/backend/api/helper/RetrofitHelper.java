package g10.manga.comicable.backend.api.helper;

import g10.manga.comicable.dictionary.api.BaseUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit getInstance() {
        return new Retrofit.Builder().baseUrl(BaseUrl.URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
