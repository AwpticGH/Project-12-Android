package g10.manga.comicable.backend.api.call;

import java.util.List;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.ListResponseModel;
import g10.manga.comicable.backend.app.model.manga.ListModel;
import retrofit2.Call;

public class ListCall extends BaseCall {

    private List<ListModel> lists;

    public ListCall(Class<BaseInterface> myInterface) {
        super(myInterface);
    }

    public Call<ListResponseModel> getAllComics() {
//        return api.getAllComics();
//        enqueue(new Callback<ListResponse>() {
//            @Override
//            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
//                assert response.body() != null;
//                if (response.body().isSuccess()) {
//                    Log.d("Call Result Boolean", "Result : " + response.body().isSuccess());
//                    lists = response.body().getLists();
//                    for (ListModel list : lists) {
//                        Log.d("Call Result(Success)", "Title : " + list.getTitle());
//                        Log.d("Call Result(Success)", "Endpoint : " + list.getEndpoint());
//                        Log.d("Call Result(Success)", "Image : " + list.getImage());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListResponse> call, Throwable t) {
//                Log.e("Call Result(Fail)", t.getLocalizedMessage());
//            }
//        });
        return null;
    }

}
