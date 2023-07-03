package g10.manga.comicable.frontend.listener.callback.activity.chapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import g10.manga.comicable.backend.api.model.chapter.PaginationModel;
import g10.manga.comicable.flag.backend.api.ResponseFlag;
import g10.manga.comicable.flag.backend.api.chapter.PaginationFlag;
import g10.manga.comicable.frontend.adapter.activity.chapter.ChapterAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.activity.comic.chapter.ButtonPaginationListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterCallback<T> extends BaseListener implements Callback<T> {

    private RecyclerView rvChapter;
    private AppCompatTextView tvChapter;

    private AppCompatButton btnPrev, btnNext;

    public ChapterCallback(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        ResponseModel<DataModel> responseModel = null;
        try {
            responseModel = (ResponseModel<DataModel>) response.body();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
            ToastHelper.apiFailed(activity);
        }
        finally {
            if (responseModel != null) {
                if (ResponseFlag.isSuccessful(responseModel) || ResponseFlag.isPartiallySuccessful(responseModel)) {
                    rvChapter = activity.findViewById(R.id.rv_chapter_activity_chapter);
                    rvChapter.setHasFixedSize(true);
                    rvChapter.setLayoutManager(new LinearLayoutManager(activity));

                    btnPrev = activity.findViewById(R.id.button_previous_activity_chapter);
                    btnNext = activity.findViewById(R.id.button_next_activity_chapter);
                    tvChapter = activity.findViewById(R.id.tv_chapter_title_activity_chapter);

                    if (PaginationFlag.hasPrevious(responseModel.getData().getPagination())) {
                        enablePaginationButton(btnPrev);
                        initPaginationPrevious(responseModel.getData().getPagination());
                    }
                    else {
                        disablePaginationButton(btnPrev);
                    }

                    if (PaginationFlag.hasNext(responseModel.getData().getPagination())) {
                        enablePaginationButton(btnNext);
                        initPaginationNext(responseModel.getData().getPagination());
                    }
                    else {
                        disablePaginationButton(btnNext);
                    }
                }
                if (ResponseFlag.isSuccessful(responseModel)) {
                    ToastHelper.apiSuccessful(activity).show();

                    initChapterDetail(responseModel.getData());
                }
                else if (ResponseFlag.isPartiallySuccessful(responseModel)) {
                    ToastHelper.apiPartiallySuccessful(activity).show();

                    if (responseModel.getData().getImages() != null || !responseModel.getData().getImages().isEmpty()) {
                        initChapterDetail(responseModel.getData());
                    }
                }
                else if (ResponseFlag.isFailed(responseModel)) {
                    ToastHelper.apiFailed(activity).show();
                    activity.finish();
                }
            }
            else {
                ToastHelper.apiFailed(activity).show();
                activity.finish();
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull Throwable t) {
        ToastHelper.networkError(activity).show();
        activity.finish();
        throw new RuntimeException(t);
    }

    private void initChapterDetail(DataModel model) {
        tvChapter.setText(model.getTitle());

        ChapterAdapter chapterAdapter = new ChapterAdapter(activity, model.getImages());
        rvChapter.setAdapter(chapterAdapter);
        chapterAdapter.notifyDataSetChanged();
    }

    private void enablePaginationButton(AppCompatButton button) {
        button.setEnabled(true);
        button.setAlpha(1.0f);
    }

    private void disablePaginationButton(AppCompatButton button) {
        button.setEnabled(false);
        button.setAlpha(0.5f);
    }

    private void initPaginationPrevious(PaginationModel model) {
        btnPrev.setOnClickListener(new ButtonPaginationListener(activity, model.getPrevious()));
    }

    private void initPaginationNext(PaginationModel model) {
        btnNext.setOnClickListener(new ButtonPaginationListener(activity, model.getNext()));
    }
}
