package g10.manga.comicable.backend.app.controller.firebase.auth;

import static org.junit.Assert.*;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.config.firebase.DatabaseConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;
import g10.manga.comicable.dictionary.firebase.DatabaseDictionary;

public class DatabaseControllerTest {

    private AuthenticationController authenticationController;
    private DatabaseController databaseController;
    private AuthModel model;

    @Before
    public void setUp() throws Exception {
        authenticationController = new AuthenticationController();
        databaseController = new DatabaseController();
        model = new AuthModel();
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("refresh");
        model.setFirst_name("Rafi Fajar");
        model.setLast_name("Sulaiman");
        model.setVerified(false);

    }

    @After
    public void tearDown() throws Exception {
        Task<Void> task = DatabaseConfig.getDatabaseReference(DatabaseDictionary.REFERENCE_AUTH)
                        .child(AuthConfig.getFirebaseUser().getUid())
                        .removeValue();

        try {
            Tasks.await(task);
            if (task.isSuccessful()) {
                AuthConfig.getFirebaseUser().delete();
            }
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
        boolean registeredAuth = authenticationController.create(model);
        boolean registeredData = false;
        if (registeredAuth) {
            registeredData = databaseController.create(model);
        }

        Assert.assertTrue(registeredData);
    }

    @Test
    public void testRead() {
        boolean registeredAuth = authenticationController.create(model);
        boolean registeredData = false;
        if (registeredAuth) {
            registeredData = databaseController.create(model);
        }
        AuthModel result = null;
        if (registeredData) {
            result = databaseController.read();
        }

        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateNotEqual() {
        boolean registeredAuth = authenticationController.create(model);
        boolean registeredData = false;
        if (registeredAuth) {
            registeredData = databaseController.create(model);
        }
        boolean updated = false;
        AuthModel newModel;
        if (registeredData) {
            newModel = new AuthModel();
            newModel.setLast_name("Solomon");
            updated = databaseController.update(newModel);
        }
        AuthModel result = null;
        if (updated) {
            result = databaseController.read();
        }

        assert result != null;
        Assert.assertNotSame(result.getLast_name(), model.getLast_name());
    }

}