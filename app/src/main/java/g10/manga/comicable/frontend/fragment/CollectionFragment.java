package g10.manga.comicable.frontend.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.islamkhsh.CardSliderViewPager;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.task.CollectionTask;
import g10.manga.comicable.frontend.listener.firebase.database.collections.fragment.collection.CollectionsReadListener;

public class CollectionFragment extends Fragment {

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        CollectionTask task = new CollectionTask();
        CollectionsReadListener listener = new CollectionsReadListener((AppCompatActivity) getActivity());
        task.read().addOnCompleteListener(listener);
    }
}