package g10.manga.comicable.backend.api.call;

import g10.manga.comicable.backend.api.interfaces.BaseInterface;
import g10.manga.comicable.backend.api.model.InfoResponseModel;
import g10.manga.comicable.backend.app.model.manga.InfoModel;
import retrofit2.Call;

public class InfoCall extends BaseCall{

    private InfoModel info;

    public InfoCall(Class<BaseInterface> myInterface) {
        super(myInterface);
    }

    public Call<InfoResponseModel> getComicInfo(String endpoint) {
        return null;
//        return api.getComicInfo(endpoint);
//        call.enqueue(new Callback<InfoResponse>() {
//            @Override
//            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
//                assert response.body() != null;
//                if (response.body().isSuccess()) {
//                    info = response.body().getInfo();
//
//                    Log.d("Call Result(success)", "Author : " + info.getAuthor());
//                    Log.d("Call Result(success)", "Title : " + info.getTitle());
//                    Log.d("Call Result(success)", "Genre : " + info.getGenres().toString());
//                    for (ChapterListModel chapter : info.getChapterList()) {
//                        Log.d("Call Result(success)", "Chapter : " + chapter.getName());
//                        Log.d("Call Result(success)", "Chapter Endpoint : " + chapter.getEndpoint());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<InfoResponse> call, Throwable t) {
//                Log.e("Call Result(fail)", t.getLocalizedMessage());
//            }
//        });
    }
}
