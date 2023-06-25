package g10.manga.comicable.backend.app.controller.firebase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void readAllComic_success() {
    }

    @Test
    public void create_success() {
    }

    @Test
    public void delete_success() {
    }

    public void createBatch() {
    }
}