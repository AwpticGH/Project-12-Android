package g10.manga.comicable.backend.app.controller.firebase.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import g10.manga.comicable.backend.app.model.AuthModel;

public class AuthControllerTest {

    @Test
    public void readAccountDetail_success() {
        AuthModel model = new AuthModel();
        model.setEmail("rafihariyadi01@gmail.com");
        model.setPassword("refresh");

        LoginController loginController = new LoginController();
        loginController.loginWithEmailAndPassword(model);

        AuthController controller = new AuthController();
        AuthModel newModel = controller.read();
        assertFalse(newModel.isVerified());
    }

    @Test
    public void updateAccountDetail_success() {
    }
}