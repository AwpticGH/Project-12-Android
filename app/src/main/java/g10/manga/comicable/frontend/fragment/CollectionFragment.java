package g10.manga.comicable.frontend.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.islamkhsh.CardSliderViewPager;

import java.util.List;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
//import g10.manga.comicable.frontend.adapter.PopularAdapter;

public class CollectionFragment extends Fragment {

    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private CardSliderViewPager cardSliderViewPager;

//    private PopularAdapter popularAdapter;
    private List<CheckpointModel> checkpoints;

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data");

//        cardSliderViewPager = rootView.findViewById(R.id.viewPager);

        recyclerView = rootView.findViewById(R.id.rv_collection);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        checkpointController = new CheckpointController();
//        checkpointController.readAll(MainActivity.getAuthModel())
//                .addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DataSnapshot> task) {
//                        if (task.isSuccessful()) {
//                            checkpoints = new ArrayList<>();
//                            for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
//                                checkpoints.add(dataSnapshot.getValue(CheckpointModel.class));
//                            }
//
//                            models = new ArrayList<>();
//                            for (CheckpointModel checkpoint : checkpoints) {
////                                models.add(checkpoint.getManga());
//                            }
//
//                            setAdapter(models);
//                        }
//                    }
//                });

    }

//    private void setAdapter(List<PopularModelOld> models) {
//        popularAdapter = new PopularAdapter(models, getActivity(), this,
//                R.id.cvTerbaru, R.id.tvTitle, R.id.imgPhoto, R.id.tvDate, R.id.tvType);
//        recyclerView.setAdapter(popularAdapter);
//        popularAdapter.notifyDataSetChanged();
//    }

//    @Override
//    public void onSelected(PopularModelOld model) {
//        Intent intent = new Intent(getActivity(), SeriesActivity.class);
//        intent.putExtra("endpoint", model.getEndpoint());
//        intent.putExtra("comic", model);
//        startActivity(intent);
//    }
}