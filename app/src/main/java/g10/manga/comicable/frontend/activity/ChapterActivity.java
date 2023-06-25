package g10.manga.comicable.frontend.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import g10.manga.comicable.R;
import g10.manga.comicable.frontend.adapter.ChapterAdapter;
import g10.manga.comicable.backend.api.call.ChapterCall;
import g10.manga.comicable.backend.app.controller.firebase.CheckpointController;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;

public class ChapterActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Toolbar toolbar;
    private TextView tvChapterName;
    private ImageView imgChapter;
    private ViewPager viewPager;
    private Button btnNext, btnPrev;

    private ChapterCall call;
    private ChapterAdapter adapter;

    private CheckpointModel checkpointModel;
    private CheckpointController checkpointController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
//        checkpointController = new CheckpointController();
//        checkpointModel = (CheckpointModel) getIntent().getSerializableExtra("checkpoint");
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Mohon Tunggu");
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Sedang menampilkan gambar");
//
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        assert getSupportActionBar() != null;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        tvChapterName = findViewById(R.id.tvTitle);
//        tvChapterName.setSelected(true);
//
//        viewPager = findViewById(R.id.viewPager);
//        btnNext = findViewById(R.id.btnNext);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int currentItem = viewPager.getCurrentItem();
//                viewPager.setCurrentItem(currentItem + 1);
//            }
//        });
//
//        btnPrev = findViewById(R.id.btnPrev);
//        btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int currentItem = viewPager.getCurrentItem();
//                viewPager.setCurrentItem(currentItem - 1);
//            }
//        });
//
//        call = new ChapterCall(getString(R.string.MANGA_API_BASE_URL));
//        String endpoint = getIntent().getStringExtra("endpoint");
//        Log.d(getLocalClassName(), "Chapter Endpoint : " + endpoint);
//
//        progressDialog.show();
//        call.getChapterDetail(endpoint).enqueue(new Callback<ChapterResponseModel>() {
//            @Override
//            public void onResponse(Call<ChapterResponseModel> call, Response<ChapterResponseModel> response) {
//                Log.d("Call URL", call.request().url().toString());
//                assert response.body() != null;
//                if (response.body().isSuccess()) {
//                    model = response.body().getChapter();
//                    tvChapterName.setText(model.getTitle());
//                    setImage(model);
//
//                    if (checkpointModel != null) {
//                        checkpointModel.setChapter(model);
//                        checkpointController.update(MainActivity.getAuthModel(), checkpointModel);
//                    }
//                    progressDialog.dismiss();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ChapterResponseModel> call, Throwable t) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        "Failed Loading Resources",
//                        Toast.LENGTH_SHORT
//                ).show();
//                finish();
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
