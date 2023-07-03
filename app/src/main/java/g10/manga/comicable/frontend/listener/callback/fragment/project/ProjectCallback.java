package g10.manga.comicable.frontend.listener.callback.fragment.project;

import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.ProjectCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import g10.manga.comicable.backend.api.model.project.PaginationModel;
import g10.manga.comicable.backend.api.model.project.ProjectModel;
import g10.manga.comicable.flag.backend.api.ResponseFlag;
import g10.manga.comicable.flag.backend.api.project.PaginationFlag;
import g10.manga.comicable.flag.backend.api.project.ProjectFlag;
import g10.manga.comicable.frontend.adapter.fragment.project.ProjectAdapter;
import g10.manga.comicable.frontend.helper.ToastHelper;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.adapter.fragment.project.SpinnerListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectCallback<T> extends BaseListener implements Callback<T> {

    private ResponseModel<DataModel> responseModel;
    private final ContentLoadingProgressBar progressBar;
    private final RecyclerView rvProject;
    private final AppCompatSpinner spinner;
    private SpinnerListener spinnerListener;
    private final ProjectCall projectCall;
    private ArrayAdapter<String> spinnerAdapter;
    private int debug = 0;

    public ProjectCallback(AppCompatActivity activity, ProjectCall projectCall) {
        super(activity);
        this.projectCall = projectCall;
        progressBar = activity.findViewById(R.id.pb_fragment_project);
        rvProject = activity.findViewById(R.id.rv_project);
        spinner = activity.findViewById(R.id.spinner_fragment_project);
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        try {
            responseModel = (ResponseModel<DataModel>) response.body();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
        finally {
            if (responseModel != null) {
                if (ResponseFlag.isSuccessful(responseModel) || ResponseFlag.isPartiallySuccessful(responseModel)) {
                    rvProject.setHasFixedSize(true);
                    rvProject.setLayoutManager(new LinearLayoutManager(activity));

                    if (!ProjectFlag.isEmpty(responseModel.getData())) {
                        initProjects(responseModel.getData().getProjects());
                    }
                    if (!PaginationFlag.isEmpty(responseModel.getData())) {
                        initPagination(responseModel.getData().getPagination());
                    }
                }
                if (ResponseFlag.isSuccessful(responseModel)) {
                    ToastHelper.apiSuccessful(activity).show();
                }
                else if (ResponseFlag.isPartiallySuccessful(responseModel)) {
                    ToastHelper.apiPartiallySuccessful(activity).show();
                }
                else if (ResponseFlag.isFailed(responseModel)) {
                    ToastHelper.apiFailed(activity).show();
                }
            }
            else {
                ToastHelper.unknownError(activity).show();
            }
            progressBar.hide();
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        ToastHelper.networkError(activity).show();
        progressBar.hide();
    }

    private void initProjects(List<ProjectModel> models) {
        ProjectAdapter projectAdapter = new ProjectAdapter(activity, models);
        rvProject.setAdapter(projectAdapter);
        projectAdapter.notifyDataSetChanged();
    }

    private void initPagination(List<PaginationModel> models) {
        int size = models.size();
        String[] pages = new String[size + 1];
        pages[0] = "Page";
        for (int i = 0; i < size; i++) {
            pages[i + 1] = models.get(i).getName();
        }

        spinner.setSelection(Adapter.NO_SELECTION, false);
        spinnerAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, pages);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        if (spinnerListener == null) {
            try {
                spinnerListener = new SpinnerListener(activity, projectCall, (ProjectCallback<ResponseModel<DataModel>>) this, progressBar);
            }
            catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
        if (spinner.getOnItemSelectedListener() == null) {
            spinner.setOnItemSelectedListener(spinnerListener);
        }
    }

}
