package g10.manga.comicable.frontend.activity.comic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;

import com.akshay.library.CurveBottomBar;

import g10.manga.comicable.R;
import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.task.auth.DatabaseTask;
import g10.manga.comicable.flag.backend.firebase.AuthFlag;
import g10.manga.comicable.frontend.activity.auth.LoginActivity;
import g10.manga.comicable.frontend.fragment.CollectionFragment;
import g10.manga.comicable.frontend.fragment.ProjectFragment;
import g10.manga.comicable.frontend.fragment.HomeFragment;
import g10.manga.comicable.frontend.fragment.SearchFragment;
import g10.manga.comicable.frontend.listener.activity.comic.main.CurveBottomBarListener;
import g10.manga.comicable.frontend.listener.activity.comic.main.ImageViewLogoListener;
import g10.manga.comicable.frontend.listener.firebase.database.users.login.UsersReadListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO : Disable window default toolbar for api 28

        if (savedInstanceState == null) {
            SearchFragment searchFragment = new SearchFragment();
            HomeFragment homeFragment = new HomeFragment();
            ProjectFragment projectFragment = new ProjectFragment();
            CollectionFragment collectionFragment = new CollectionFragment();
            CurveBottomBar navigation = findViewById(R.id.curve_bottom_bar);
            navigation.setOnItemSelectedListener(new CurveBottomBarListener(this, searchFragment, homeFragment, projectFragment, collectionFragment));
            navigation.setSelectedItemId(R.id.navigation_home);

            AppCompatTextView tvToolbar = findViewById(R.id.tv_toolbar_main_toolbar);
            String greeting = "Halo, \n" + AuthConfig.getFirebaseUser().getDisplayName();
            tvToolbar.setText(greeting);

            AppCompatImageView ivSetting = findViewById(R.id.iv_setting_main_toolbar);
            ivSetting.setOnClickListener(new ImageViewLogoListener(this));

            /* Attempt to read user data from db, in case it has not been registered
             * If user has not been registered, will reattempt to register it
             */
            DatabaseTask databaseTask = new DatabaseTask();
            databaseTask.read().addOnCompleteListener(new UsersReadListener(this));
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!AuthFlag.isAuthenticated()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}