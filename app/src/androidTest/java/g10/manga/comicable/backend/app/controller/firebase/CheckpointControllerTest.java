package g10.manga.comicable.backend.app.controller.firebase;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.controller.firebase.auth.AuthenticationController;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.model.firebase.CheckpointModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;

public class CheckpointControllerTest {

    private AuthenticationController authenticationController;
    private AuthModel authModel;
    private CollectionController collectionController;
    private CollectionModel collectionModel;
    private CheckpointController checkpointController;
    private CheckpointModel checkpointModel;
    private final String title = "Kang Item";
    private final String chapter = "chapter-126";
    CollectionModel[] collectionModels = new CollectionModel[3];
    CheckpointModel[] checkpointModels = new CheckpointModel[2];

    @Before
    public void setUp() throws Exception {
        authModel = new AuthModel();
        authModel.setEmail("rafihariyadi01@gmail.com");
        authModel.setPassword("refresh");

        authenticationController = new AuthenticationController();
        authenticationController.create(authModel);

        collectionModel = new CollectionModel();
        collectionModel.setTitle(title);
        collectionModel.setUser(AuthConfig.getFirebaseUser().getUid());

        collectionController = new CollectionController();
        collectionController.create(collectionModel);
        collectionModel = collectionController.read(title);

        checkpointModel = new CheckpointModel();
        checkpointModel.setChapter(chapter);
        checkpointModel.setCollection(collectionModel.getUid());

        checkpointController = new CheckpointController();
    }

    @After
    public void tearDown() throws Exception {
        checkpointController.delete(checkpointModel);
        collectionController.delete(collectionModel);
        AuthConfig.getFirebaseUser().delete();
    }

    @Test
    public void create_success() {
        boolean result = checkpointController.create(checkpointModel);
        assertTrue(result);
    }

    @Test
    public void readOneChapter_notNull_success() {
        checkpointController.create(checkpointModel);

        CheckpointModel result = checkpointController.read(checkpointModel, collectionModel);
        assertNotNull(result);
    }

    @Test
    public void readOneChapter_nameEquals_success() {
        checkpointController.create(checkpointModel);

        CheckpointModel result = checkpointController.read(checkpointModel, collectionModel);
        assertEquals(result.getChapter(), chapter);
    }

    @Test
    public void readOneChapter_uidEquals_success() {
        checkpointController.create(checkpointModel);

        CheckpointModel result = checkpointController.read(checkpointModel, collectionModel);
        assertNotNull(result.getCollection(), collectionModel.getUid());
    }

    @Test
    public void readAllChapter_notNull_success() {
        createBatch();

        List<CheckpointModel> results = checkpointController.read(List.of(collectionModels));

        deleteBatch();
        assertNotNull(results);
    }

    @Test
    public void readAllChapter_lengthNotEqualToCollection_success() {
        createBatch();

        List<CheckpointModel> results = checkpointController.read(List.of(collectionModels));

        deleteBatch();
        assertNotEquals(results.size(), collectionModels.length);
    }

    @Test
    public void readAllChapter_lengthEqualsToCollectionDecreasedByOne_success() {
        createBatch();

        List<CheckpointModel> results = checkpointController.read(List.of(collectionModels));

        deleteBatch();
        assertEquals(results.size(), collectionModels.length - 1);
    }

    @Test
    public void readAllChapter_allChapterCollectionUidMatchesWithCollectionModels_true_success() {
        createBatch();

        List<CheckpointModel> results = checkpointController.read(List.of(collectionModels));
        Boolean[] expecteds = new Boolean[results.size()];
        for (int i = 0; i < results.size(); i++) {
            for (CollectionModel collection : collectionModels) {
                if (Objects.equals(results.get(i).getCollection(), collection.getUid())) {
                    expecteds[i] = true;
                    break;
                }
            }
        }

        deleteBatch();
        assertTrue(Arrays.stream(expecteds).allMatch(Boolean::booleanValue));
    }

    @Test
    public void update_true_success() {
        checkpointController.create(checkpointModel);
        checkpointModel = checkpointController.read(checkpointModel, collectionModel);

        String newChapter = "chapter-10";
        checkpointModel.setChapter(newChapter);
        boolean result = checkpointController.update(checkpointModel);
        assertTrue(result);
    }

    @Test
    public void update_newChapterIsNotEqualToPreviousChapter_success() {
        checkpointController.create(checkpointModel);
        checkpointModel = checkpointController.read(checkpointModel, collectionModel);

        String newChapter = "chapter-10";
        checkpointModel.setChapter(newChapter);
        checkpointController.update(checkpointModel);

        checkpointModel = checkpointController.read(checkpointModel, collectionModel);

        assertNotEquals(checkpointModel.getChapter(), chapter);
    }

    @Test
    public void update_newChapterIsEqual_success() {
        checkpointController.create(checkpointModel);
        checkpointModel = checkpointController.read(checkpointModel, collectionModel);

        String newChapter = "chapter-10";
        checkpointModel.setChapter(newChapter);
        checkpointController.update(checkpointModel);

        checkpointModel = checkpointController.read(checkpointModel, collectionModel);

        assertEquals(checkpointModel.getChapter(), newChapter);
    }

    @Test
    public void delete_success() {
        checkpointController.create(checkpointModel);
        checkpointModel = checkpointController.read(checkpointModel, collectionModel);

        boolean result = checkpointController.delete(checkpointModel);
        assertTrue(result);
    }

    private void createBatch() {
        collectionModels[0] = new CollectionModel();
        collectionModels[0].setTitle("Ranker's Return (Remake)");
        collectionModels[0].setUser(AuthConfig.getFirebaseUser().getUid());

        collectionModels[1] = new CollectionModel();
        collectionModels[1].setTitle("Superhuman Battlefield");
        collectionModels[1].setUser(AuthConfig.getFirebaseUser().getUid());

        collectionModels[2] = new CollectionModel();
        collectionModels[2].setTitle("Bakayarou");
        collectionModels[2].setUser(AuthConfig.getFirebaseUser().getUid());

        for (CollectionModel data : collectionModels) {
            collectionController.create(data);
        }

        collectionModels[0] = collectionController.read("Ranker's Return (Remake)");
        collectionModels[1] = collectionController.read("Superhuman Battlefield");
        collectionModels[2] = collectionController.read("Bakayarou");

        checkpointModels[0] = new CheckpointModel();
        checkpointModels[0].setChapter("chapter-01");
        checkpointModels[0].setCollection(collectionModels[0].getUid());

        checkpointModels[1] = new CheckpointModel();
        checkpointModels[1].setChapter("chapter-02");
        checkpointModels[1].setCollection(collectionModels[1].getUid());

        for (CheckpointModel data : checkpointModels) {
            checkpointController.create(data);
        }
    }

    private void deleteBatch() {
        for (CollectionModel data : collectionModels) {
            collectionController.delete(data);
        }
        for (CheckpointModel data : checkpointModels) {
            checkpointController.delete(data);
        }
    }
}