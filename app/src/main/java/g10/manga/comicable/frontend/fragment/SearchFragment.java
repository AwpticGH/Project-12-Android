package g10.manga.comicable.frontend.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import g10.manga.comicable.R;
import g10.manga.comicable.frontend.listener.fragment.search.ButtonSearchListener;

public class SearchFragment extends Fragment {

    private String page;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatImageButton ibSearch = view.findViewById(R.id.ib_search_fragment_search);
        ibSearch.setOnClickListener(new ButtonSearchListener((AppCompatActivity) getActivity()));
    }
}