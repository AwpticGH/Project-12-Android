package g10.manga.comicable.frontend.listener.activity.comic.main;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.akshay.library.CurveBottomBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import g10.manga.comicable.R;
import g10.manga.comicable.frontend.fragment.CollectionFragment;
import g10.manga.comicable.frontend.fragment.ProjectFragment;
import g10.manga.comicable.frontend.fragment.HomeFragment;
import g10.manga.comicable.frontend.fragment.SearchFragment;
import g10.manga.comicable.frontend.listener.BaseListener;

public class CurveBottomBarListener extends BaseListener implements NavigationBarView.OnItemSelectedListener {

    private final SearchFragment searchFragment;
    private final HomeFragment homeFragment;
    private final ProjectFragment projectFragment;
    private final CollectionFragment collectionFragment;

    private final FloatingActionButton fab;
    private final Menu menu;

    public CurveBottomBarListener(
            AppCompatActivity activity,
            SearchFragment searchFragment,
            HomeFragment homeFragment,
            ProjectFragment projectFragment,
            CollectionFragment collectionFragment
    ) {
        super(activity);
        this.searchFragment = searchFragment;
        this.homeFragment = homeFragment;
        this.projectFragment = projectFragment;
        this.collectionFragment = collectionFragment;
        fab = activity.findViewById(R.id.floating_action_button);
        CurveBottomBar cbb = activity.findViewById(R.id.curve_bottom_bar);
        menu = cbb.getMenu();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_search) {
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_fragment, searchFragment, searchFragment.getClass().getSimpleName())
                    .commit();
            reInitOtherItem(item, menu);
            item.setIcon(null);
            item.setTitle("");
            fab.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_search));
            return true;
        }

        if (item.getItemId() == R.id.navigation_home) {
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_fragment, homeFragment, homeFragment.getClass().getSimpleName())
                    .commit();
            reInitOtherItem(item, menu);
            item.setIcon(null);
            item.setTitle("");
            fab.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_home));
            return true;
        }

        if (item.getItemId() == R.id.navigation_project) {
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_fragment, projectFragment, projectFragment.getClass().getSimpleName())
                    .commit();
            reInitOtherItem(item, menu);
            item.setIcon(null);
            item.setTitle("");
            fab.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_project));
            return true;
        }

        if (item.getItemId() == R.id.navigation_collection) {
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_fragment, collectionFragment, collectionFragment.getClass().getSimpleName())
                    .commit();
            reInitOtherItem(item, menu);
            item.setIcon(null);
            item.setTitle("");
            fab.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_comic));
            return true;
        }
        return false;
    }

    private void reInitOtherItem(MenuItem currentItem, Menu menu) {
        if (currentItem.getItemId() == R.id.navigation_search) {
            MenuItem otherItem = menu.findItem(R.id.navigation_home);
            Log.d(getClass().getSimpleName(), "otherItem : " + otherItem);
            if (hasEmptyIcon(otherItem)) {
                fillHome(otherItem);
            }
            else {
                otherItem = menu.findItem(R.id.navigation_project);
                if (hasEmptyIcon(otherItem)) {
                    fillProject(otherItem);
                }
                else {
                    otherItem = menu.findItem(R.id.navigation_collection);
                    if (hasEmptyIcon(otherItem)) {
                        fillCollection(otherItem);
                    }
                }
            }
        }

        if (currentItem.getItemId() == R.id.navigation_home) {
            MenuItem otherItem = menu.findItem(R.id.navigation_search);
            if (hasEmptyIcon(otherItem)) {
                fillSearch(otherItem);
            }
            else {
                otherItem = menu.findItem(R.id.navigation_project);
                if (hasEmptyIcon(otherItem)) {
                    fillProject(otherItem);
                }
                else {
                    otherItem = menu.findItem(R.id.navigation_collection);
                    if (hasEmptyIcon(otherItem)) {
                        fillCollection(otherItem);
                    }
                }
            }
        }

        if (currentItem.getItemId() == R.id.navigation_project) {
            MenuItem otherItem = menu.findItem(R.id.navigation_search);
            if (hasEmptyIcon(otherItem)) {
                fillSearch(otherItem);
            }
            else {
                otherItem = menu.findItem(R.id.navigation_home);
                if (hasEmptyIcon(otherItem)) {
                    fillHome(otherItem);
                }
                else {
                    otherItem = menu.findItem(R.id.navigation_collection);
                    if (hasEmptyIcon(otherItem)) {
                        fillCollection(otherItem);
                    }
                }
            }
        }

        if (currentItem.getItemId() == R.id.navigation_collection) {
            MenuItem otherItem = menu.findItem(R.id.navigation_search);
            if (hasEmptyIcon(otherItem)) {
                fillSearch(otherItem);
            }
            else {
                otherItem = menu.findItem(R.id.navigation_home);
                if (hasEmptyIcon(otherItem)) {
                    fillHome(otherItem);
                }
                else {
                    otherItem = menu.findItem(R.id.navigation_project);
                    if (hasEmptyIcon(otherItem)) {
                        fillProject(otherItem);
                    }
                }
            }
        }
    }

    private boolean hasEmptyIcon(MenuItem item) {
        return item != null && item.getIcon() == null;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void fillSearch(MenuItem item) {
        Log.d(getClass().getSimpleName(), "fillSearch");
        item.setIcon(activity.getResources().getDrawable(R.drawable.ic_search));
        item.setTitle(activity.getResources().getString(R.string.navigation_title_search));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void fillHome(MenuItem item) {
        Log.d(getClass().getSimpleName(), "fillHome");
        item.setIcon(activity.getResources().getDrawable(R.drawable.ic_home));
        item.setTitle(activity.getResources().getString(R.string.navigation_title_home));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void fillProject(MenuItem item) {
        Log.d(getClass().getSimpleName(), "fillProject");
        item.setIcon(activity.getResources().getDrawable(R.drawable.ic_project));
        item.setTitle(activity.getResources().getString(R.string.navigation_title_project));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void fillCollection(MenuItem item) {
        Log.d(getClass().getSimpleName(), "fillCollection");
        item.setIcon(activity.getResources().getDrawable(R.drawable.ic_comic));
        item.setTitle(activity.getResources().getString(R.string.navigation_title_collection));
    }
}
