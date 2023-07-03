package g10.manga.comicable.frontend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.ProjectCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import g10.manga.comicable.frontend.listener.callback.fragment.project.ProjectCallback;

public class ProjectFragment extends Fragment {

    private String page;

    public ProjectFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        if (savedInstanceState == null) {
            ContentLoadingProgressBar progressBar = rootView.findViewById(R.id.pb_fragment_project);
            progressBar.show();

            if (page == null) {
                page = "1";
            }

            ProjectCall call = new ProjectCall();
            ProjectCallback<ResponseModel<DataModel>> callback = new ProjectCallback<>((AppCompatActivity) getActivity(), call);
            call.get(page).enqueue(callback);
        }
    }


}
