package g10.manga.comicable.backend.app.controller.auth;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import g10.manga.comicable.backend.app.model.AuthModel;

@RunWith(AndroidJUnit4.class)
public class LoginControllerTest {

    private LoginController controller;
    private AuthModel model;

    @Before
    public void setUp() throws Exception {
        controller = new LoginController();
        model = new AuthModel();
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("refresh");
    }

    @Test
    public void successLoginWithEmailAndPassword() {
        boolean authenticated = controller.loginWithEmailAndPassword(model);
        assertTrue(authenticated);
    }
}