package g10.manga.comicable.backend.api.controller.traditional;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.project.DataModel;
import g10.manga.comicable.dictionary.api.ResponseMessages;

public class ProjectControllerTest {

    private static String page;
    private static ProjectController controller;
    private static ResponseModel<DataModel> response;

    @BeforeClass
    public static void beforeClass() throws Exception {
        page = "1";
        controller = new ProjectController();
        response = controller.get(page);
    }

    @Test
    public void statusEqualsTo200() {
        assertEquals(response.getStatus(), "200");
    }

    @Test
    public void messageIsNotFail() {
        assertNotEquals(response.getMessage(), ResponseMessages.FAILED);
    }

    @Test
    public void dataIsNotNull() {
        assertNotNull(response.getData());
    }
}