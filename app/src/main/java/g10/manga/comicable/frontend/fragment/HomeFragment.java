package g10.manga.comicable.frontend.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.api.controller.original.HomeCall;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.home.DataModel;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.frontend.listener.callback.fragment.home.HomeCallback;

public class HomeFragment extends Fragment  {

    private AppCompatTextView tvGreeting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        tvGreeting = rootView.findViewById(R.id.tv_greeting_home_header);

        ProgressBar pbTrending = rootView.findViewById(R.id.pb_trending_fragment_home);
        ProgressBar pbLatest = rootView.findViewById(R.id.pb_latest_fragment_home);
        ProgressBar pbMirror = rootView.findViewById(R.id.pb_mirror_fragment_home);

        pbTrending.setVisibility(View.VISIBLE);
        pbLatest.setVisibility(View.VISIBLE);
        pbMirror.setVisibility(View.VISIBLE);

        HomeCall homeCall = new HomeCall();
        HomeCallback<ResponseModel<DataModel>> callback = new HomeCallback<>((AppCompatActivity) getActivity());
        homeCall.get().enqueue(callback);
        setGreeting();
    }

    @SuppressLint("SetTextI18n")
    private void setGreeting() {
        String firstName = AuthConfig.getFirebaseUser().getDisplayName();
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            tvGreeting.setText("Selamat Pagi " + firstName);
        }
        else if (timeOfDay < 15) {
            tvGreeting.setText("Selamat Siang " + firstName);
        }
        else if (timeOfDay < 18) {
            tvGreeting.setText("Selamat Sore " + firstName);
        }
        else {
            tvGreeting.setText("Selamat Malam " + firstName);
        }
    }

}
