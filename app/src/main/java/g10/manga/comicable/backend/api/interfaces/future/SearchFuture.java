package g10.manga.comicable.backend.api.interfaces.future;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;

public interface SearchFuture {

    @RequiresApi(api = Build.VERSION_CODES.N)
    CompletableFuture<ResponseModel<DataModel>> get(String query, @Nullable String page);
}
