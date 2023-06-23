package g10.manga.comicable.backend.app.controller;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import g10.manga.comicable.backend.app.model.AuthModel;
import g10.manga.comicable.backend.app.model.CheckpointModel;

public class CheckpointController {

    private final String DB_URL = "https://ccit-project-c68fc-default-rtdb.asia-southeast1.firebasedatabase.app/";
    private final String DB_REFERENCE = "Checkpoint";
    private List<CheckpointModel> checkpoints;
    private CheckpointModel checkpoint;
    private DatabaseReference dbReference;
    private Task<DataSnapshot> task;

    public CheckpointController() {
        dbReference = FirebaseDatabase.getInstance(DB_URL).getReference(DB_REFERENCE);
    }

    public void create(AuthModel authModel, CheckpointModel checkpoint) {
//        dbReference.child(authModel.getId()).child(checkpoint.getManga().getTitle()).setValue(checkpoint);
    }

//    public Task<DataSnapshot> readAll(AuthModel authModel) {
//        return dbReference.child(authModel.getId()).get();
//    }

//    public Task<DataSnapshot> read(AuthModel authModel, String mangaTitle, OnCompleteListener<DataSnapshot> onCompleteListener) {
//        if (mangaTitle.contains(".") || mangaTitle.contains("#")
//                || mangaTitle.contains("$") || mangaTitle.contains("[")
//                || mangaTitle.contains("]"))
//            mangaTitle = mangaTitle.replace(".", "-");
//        Log.d(getClass().getSimpleName(), "mangaTitle : " + mangaTitle);
//
//        return dbReference.child(authModel.getId())
//                .child(mangaTitle)
//                .get()
//                .addOnCompleteListener(onCompleteListener);
//    }

    public void update(AuthModel authModel, CheckpointModel checkpoint) {
//        dbReference.child(authModel.getId()).child(checkpoint.getManga().getTitle()).setValue(checkpoint);
    }

    public void delete(AuthModel authModel) {
//        dbReference.child(authModel.getId()).removeValue();
    }

    public void delete(AuthModel authModel, CheckpointModel checkpoint) {
//        dbReference.child(authModel.getId()).child(checkpoint.getManga().getTitle()).removeValue();
    }
}
