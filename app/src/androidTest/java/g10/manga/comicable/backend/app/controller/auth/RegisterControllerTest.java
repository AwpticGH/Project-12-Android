package g10.manga.comicable.backend.app.controller.auth;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import g10.manga.comicable.backend.app.model.AuthModel;

public class RegisterControllerTest {

    private RegisterController controller;
    private AuthModel model;

    @Before
    public void setUp() throws Exception {
        controller = new RegisterController();
        model = new AuthModel();
        model.setEmail("testing@gmail.com");
        model.setPassword("refresh");
        model.setFirst_name("Rafi Fajar");
        model.setLast_name("Sulaiman");
        model.setVerified(false);
    }

    @Test
    public void createWithEmailAndPassword() {

    }
}