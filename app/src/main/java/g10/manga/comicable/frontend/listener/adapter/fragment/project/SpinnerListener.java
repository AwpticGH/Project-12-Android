package g10.manga.comicable.frontend.listener.adapter.fragment.project;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import g10.manga.comicable.backend.api.controller.original.ProjectCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import g10.manga.comicable.frontend.listener.BaseListener;
import g10.manga.comicable.frontend.listener.callback.ProjectCallback;

public class SpinnerListener extends BaseListener implements AdapterView.OnItemSelectedListener {

    private final ProjectCall projectCall;
    private final ProjectCallback<ResponseModel<DataModel>> projectCallback;
    private final ContentLoadingProgressBar progressBar;

    public SpinnerListener(
            AppCompatActivity activity,
            ProjectCall projectCall,
            ProjectCallback<ResponseModel<DataModel>> projectCallback,
            ContentLoadingProgressBar progressBar
    ) {
        super(activity);
        this.projectCall = projectCall;
        this.projectCallback = projectCallback;
        this.progressBar = progressBar;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!adapterView.getSelectedItem().equals("Page")) {
            progressBar.show();
            String page = adapterView.getItemAtPosition(i).toString();
            projectCall.get(page).enqueue(projectCallback);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do Nothing?
    }
}
