package g10.manga.comicable.backend.app.controller.firebase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.controller.firebase.auth.AuthenticationController;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;

public class CollectionControllerTest {

    private AuthenticationController authenticationController;
    private AuthModel authModel;
    private CollectionController collectionController;
    private CollectionModel collectionModel;

    @Before
    public void setUp() throws Exception {
        authModel = new AuthModel();
        authModel.setEmail("rafihariyadi01@gmail.com");
        authModel.setPassword("refresh");

        authenticationController = new AuthenticationController();
        authenticationController.create(authModel);

        collectionModel = new CollectionModel();
        collectionModel.setTitle("Kang Item");
        collectionModel.setUser(AuthConfig.getFirebaseUser().getUid());

        collectionController = new CollectionController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void readOneComicNotNull_success() {
        collectionController.create(collectionModel);

        CollectionModel result = collectionController.read(collectionModel.getTitle());
        assertNotNull(result);
    }

    @Test
    public void readOneComicUidNotNull_success() {
        collectionController.create(collectionModel);

        CollectionModel result = collectionController.read(collectionModel.getTitle());
        assertNotNull(result.getUid());
    }

    @Test
    public void readOneComicTitleEquals_success() {
        collectionController.create(collectionModel);

        CollectionModel result = collectionController.read(collectionModel.getTitle());
        assertEquals(result.getTitle(), collectionModel.getTitle());
    }

    @Test
    public void readOneComicUserEquals_success() {
        collectionController.create(collectionModel);

        CollectionModel result = collectionController.read(collectionModel.getTitle());
        assertEquals(result.getUser(), AuthConfig.getFirebaseUser().getUid());
    }

    @Test
    public void readAllComicsNotNull_success() {
        createBatch();

        List<CollectionModel> results = collectionController.read();
        assertNotNull(results);
    }

    @Test
    public void readAllComicsResultEqualsThree_success() {
        createBatch();

        List<CollectionModel> results = collectionController.read();
        assertEquals(results.size(), 3);
    }

    @Test
    public void readAllComicsNotNull_success() {
        createBatch();

        List<CollectionModel> results = collectionController.read();
        assertNotNull(results);
    }

    @Test
    public void readAllComicsNotNull_success() {
        createBatch();

        List<CollectionModel> results = collectionController.read();
        assertNotNull(results);
    }

    @Test
    public void create_success() {
    }

    @Test
    public void delete_success() {
    }

    private void createBatch() {
        CollectionModel model1 = new CollectionModel();
        model1.setTitle("Kang Item");
        model1.setUser(AuthConfig.getFirebaseAuth().getUid());

        CollectionModel model2 = new CollectionModel();
        model2.setTitle("Ranker's Return (Remake)");
        model2.setUser(AuthConfig.getFirebaseAuth().getUid());

        CollectionModel model3 = new CollectionModel();
        model3.setTitle("Superhuman Battlefield");
        model3.setUser(AuthConfig.getFirebaseAuth().getUid());

        CollectionModel[] array = new CollectionModel[3];
        array[0] = model1;
        array[1] = model2;
        array[2] = model3;

        for (CollectionModel data : array) {
            collectionController.create(data);
        }
    }
}