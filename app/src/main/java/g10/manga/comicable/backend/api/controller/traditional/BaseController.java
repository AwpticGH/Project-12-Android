package g10.manga.comicable.backend.api.controller.traditional;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BaseController {

    protected ExecutorService executorService;

    protected BaseController() {
        executorService = Executors.newSingleThreadExecutor();
    }

    protected void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    Log.e("ExecutorService", "ExecutorService Did Not Terminate!");
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
