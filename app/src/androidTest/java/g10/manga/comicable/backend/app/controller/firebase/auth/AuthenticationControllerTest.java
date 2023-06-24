package g10.manga.comicable.backend.app.controller.firebase.auth;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;
import g10.manga.comicable.backend.app.model.firebase.AuthModel;

public class AuthenticationControllerTest {

    private AuthenticationController controller;
    private AuthModel model;

    @Before
    public void setUp() throws Exception {

        controller = new AuthenticationController();
        model = new AuthModel();
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("refresh");
        model.setFirst_name("Rafi Fajar");
        model.setLast_name("Sulaiman");
        model.setVerified(false);
    }

    @Test
    public void testCreate_success() {
        // creates a new account that has not been registered
        boolean result = controller.create(model);
        Assert.assertTrue(result);
    }

    @Test
    public void testCreate_fail() {
        /** tries to create an account that has been registered
         *  expected to fail
         */
        boolean first = controller.create(model);
        boolean second = true;
        if (first) {
            second = controller.create(model);
        }
        Assert.assertFalse(second);
    }

    @Test
    public void testLogin_success() {
        boolean registered = controller.create(model);
        boolean loggedOut = false;
        boolean result = false;
        if (registered) {
            loggedOut = controller.logout();
        }
        if (loggedOut) {
            result = controller.login(model);
        }

        Assert.assertTrue(result);
    }

    @Test
    public void testLogout_success() {
        boolean registered = controller.create(model);
        boolean loggedOut = false;
        if (registered) {
            loggedOut = controller.logout();
        }

        Assert.assertTrue(loggedOut);
    }

    @Test
    public void testUpdate() {
        boolean registered = controller.create(model);
        if (registered) {
            controller.update(model);
        }

        Assert.assertEquals(AuthConfig.getFirebaseUser().getDisplayName(), model.getFirst_name());
    }

    @After
    public void tearDown() throws Exception {
        AuthConfig.getFirebaseUser().delete();
    }

}