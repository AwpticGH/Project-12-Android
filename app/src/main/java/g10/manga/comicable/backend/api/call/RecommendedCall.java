package g10.manga.comicable.backend.api.call;

import android.util.Log;

import java.util.List;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.app.model.manga.RecommendedModel;
import g10.manga.comicable.backend.api.model.RecommendedResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendedCall extends BaseCall {

    private List<RecommendedModel> recommendeds;

    public RecommendedCall(Class<BaseInterface> myInterface) {
        super(myInterface);
    }

    public List<RecommendedModel> getRecommendeds(int page) {
        return null;
//        Call<RecommendedResponseModel> call = api.getRecommendedComics(page);
//        call.enqueue(new Callback<RecommendedResponseModel>() {
//            @Override
//            public void onResponse(Call<RecommendedResponseModel> call, Response<RecommendedResponseModel> response) {
//                assert response.body() != null;
//                if (response.body().isSuccess()) {
//                    recommendeds = response.body().getRecommendeds();
//
//                    for (RecommendedModel recommended : recommendeds) {
//                        Log.d("Call Result(success)", "Title : " + recommended.getTitle());
//                        Log.d("Call Result(success)", "Type : " + recommended.getType());
//                        Log.d("Call Result(success)", "Description : " + recommended.getDescription());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecommendedResponseModel> call, Throwable t) {
//                Log.e("Call Result(fail)", t.getLocalizedMessage());
//            }
//        });
//
//        return recommendeds;
    }
}
