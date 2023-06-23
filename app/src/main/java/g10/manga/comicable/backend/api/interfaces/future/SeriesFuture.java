package g10.manga.comicable.backend.api.interfaces.future;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;

public interface SeriesFuture {

    @RequiresApi(api = Build.VERSION_CODES.N)
    CompletableFuture<ResponseModel<DataModel>> get(String series);
}
