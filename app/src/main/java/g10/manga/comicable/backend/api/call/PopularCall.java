package g10.manga.comicable.backend.api.call;

import java.util.List;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.PopularResponseModel;
import g10.manga.comicable.backend.app.model.manga.PopularModelOld;
import retrofit2.Call;

public class PopularCall extends BaseCall {

    private List<PopularModelOld> populars;

    public PopularCall(Class<BaseInterface> myInterface) {
        super(myInterface);
    }

    public Call<PopularResponseModel> getCall(int page) {
        return null;
//        return api.getPopularComics(page);
//        call.enqueue(new Callback<PopularResponse>() {
//            @Override
//            public void onResponse(Call<PopularResponse> call, Response<PopularResponse> response) {
//                assert response.body() != null;
//                if (response.body().isSuccess()) {
//                    populars = response.body().getPopulars();
//
//                    for (PopularModel popular : populars) {
//                        Log.d("Call Result(success)", "Title : " + popular.getTitle());
//                        Log.d("Call Result(success)", "Type : " + popular.getType());
//                        Log.d("Call Result(success)", "Description : " + popular.getDescription());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PopularResponse> call, Throwable t) {
//                Log.e("Call Result(fail)", t.getLocalizedMessage());
//            }
//        });
    }
}
