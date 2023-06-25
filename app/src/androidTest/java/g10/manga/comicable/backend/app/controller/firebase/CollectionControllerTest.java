package g10.manga.comicable.backend.app.controller.firebase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.controller.firebase.auth.AuthenticationController;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.backend.app.model.firebase.CollectionModel;

public class CollectionControllerTest {

    private AuthenticationController authenticationController;
    private AuthModel authModel;
    private CollectionController collectionController;
    private CollectionModel collectionModel;
    private List<CollectionModel> collectionModels;
    private String title1 = "Ranker's Return (Remake)";
    private String title2 = "Superhuman Battlefield";
    private String title3 = "Jancok";

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
        collectionController.delete(collectionModel);
        AuthConfig.getFirebaseUser().delete();
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
        deleteBatch();

        collectionController.create(collectionModel);
        collectionModel = collectionController.read(collectionModel.getTitle());
        assertNotNull(results);
    }

    @Test
    public void readAllComicsResultEqualsThree_success() {
        createBatch();

        List<CollectionModel> results = collectionController.read();
        deleteBatch();

        collectionController.create(collectionModel);
        collectionModel = collectionController.read(collectionModel.getTitle());
        assertEquals(results.size(), 3);
    }

    @Test
    public void readAllComicsUidEqualsToCurrentUserUid_success() {
        createBatch();
        List<CollectionModel> results = collectionController.read();

        boolean isEqual = true;
        for (CollectionModel result : results) {
            if (!Objects.equals(result.getUser(), AuthConfig.getFirebaseUser().getUid())) {
                isEqual = false;
            }
        }
        deleteBatch();

        collectionController.create(collectionModel);
        collectionModel = collectionController.read(collectionModel.getTitle());

        assertTrue(isEqual);
    }

    @Test
    public void create_success() {
        boolean result = collectionController.create(collectionModel);

        assertTrue(result);
    }

    @Test
    public void delete_success() {
        collectionController.create(collectionModel);

        boolean result = collectionController.delete(collectionModel);

        collectionController.create(collectionModel); // to make sure the tearDown method works fine

        assertTrue(result);
    }

    private void createBatch() {
        CollectionModel model1 = new CollectionModel();
        model1.setTitle(title1);
        model1.setUser(AuthConfig.getFirebaseUser().getUid());

        CollectionModel model2 = new CollectionModel();
        model2.setTitle(title2);
        model2.setUser(AuthConfig.getFirebaseAuth().getUid());

        CollectionModel model3 = new CollectionModel();
        model3.setTitle(title3);
        model3.setUser(AuthConfig.getFirebaseAuth().getUid());

        collectionModels = new ArrayList<>();
        collectionModels.add(0, model1);
        collectionModels.add(1, model2);
        collectionModels.add(2, model3);

        for (CollectionModel data : collectionModels) {
            collectionController.create(data);
        }
    }

    private void deleteBatch() {
        collectionModels.set(0, collectionController.read(title1));
        collectionModels.set(1, collectionController.read(title2));
        collectionModels.set(2, collectionController.read(title3));

        for (CollectionModel data : collectionModels) {
            collectionController.delete(data);
        }
    }
}