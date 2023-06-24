package g10.manga.comicable.backend.app.controller.firebase.auth;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import g10.manga.comicable.backend.app.model.AuthModel;

public class LoginControllerTest {

    static private LoginController controller;
    private AuthModel model;
    private boolean authenticated;

    @BeforeClass
    public static void beforeClass() throws Exception {
        controller = new LoginController();
    }

    @Before
    public void setUp() throws Exception {
        model = new AuthModel();
    }

    @Test
    public void login_success() {
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("refresh");

        authenticated = controller.loginWithEmailAndPassword(model);
        assertTrue(authenticated);
    }

    @Test
    public void loginWithWrongPassword_fail() {
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("asdwad");

        authenticated = controller.loginWithEmailAndPassword(model);
        assertFalse(authenticated);
    }

    @Test
    public void loginWithInvalidCaseOnPassword_fail() {
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("Refresh");

        authenticated = controller.loginWithEmailAndPassword(model);
        assertFalse(authenticated);
    }

    @Test
    public void loginWithWrongCredentials_fail() {
        model.setEmail("ascawdwa@gmail.com");
        model.setPassword("asdwadawd");

        authenticated = controller.loginWithEmailAndPassword(model);
        assertFalse(authenticated);
    }
}