package g10.manga.comicable.backend.api.controller.traditional;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;
import g10.manga.comicable.dictionary.api.ResponseMessages;

public class SearchControllerTest {

    private static String query;
    private static String page;
    private static SearchController controllerWithPage;
    private static SearchController controllerWithoutPage;
    private static ResponseModel<DataModel> responseWithPage;
    private static ResponseModel<DataModel> responseWithoutPage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        query = "kang";
        page = "2";
        controllerWithPage = new SearchController();
        controllerWithoutPage = new SearchController();

        responseWithPage = controllerWithPage.get(query, page);
        responseWithoutPage = controllerWithoutPage.get(query, null);
    }

    @Test
    public void withoutPageStatusEqualsTo200() {
        assertEquals(responseWithoutPage.getStatus(), "200");
    }

    @Test
    public void withoutPageMessageIsNotFail() {
        assertNotEquals(responseWithoutPage.getMessage(), ResponseMessages.FAILED);
    }

    @Test
    public void withoutPageDataIsNotNull() {
        assertNotNull(responseWithoutPage.getData());
    }

    @Test
    public void withPageStatusEqualsTo200() {
        assertEquals(responseWithPage.getStatus(), "200");
    }

    @Test
    public void withPageMessageIsNotFail() {
        assertNotEquals(responseWithPage.getMessage(), ResponseMessages.FAILED);
    }

    @Test
    public void withPageDataIsNotNull() {
        assertNotNull(responseWithPage.getData());
    }
}