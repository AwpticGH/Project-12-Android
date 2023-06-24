package g10.manga.comicable.backend.app.controller.firebase.auth;

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
    }

    @Test
    public void createAuthenticationAndData_success() {
        model.setEmail("create_auth@gmail.com");
        model.setPassword("refresh");
        model.setFirst_name("Both");
        model.setLast_name("Test");

        boolean createdAuth = controller.createAuthentication(model);
        boolean createdData = false;
        if (createdAuth){
            createdData = controller.createData(model);
        }
        assertTrue(createdAuth && createdData);
    }
}
