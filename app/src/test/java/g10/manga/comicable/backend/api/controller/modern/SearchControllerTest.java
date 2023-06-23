package g10.manga.comicable.backend.api.controller.modern;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.dictionary.api.ResponseMessages;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.search.DataModel;

public class SearchControllerTest {

    static String query;
    static String page;
    static SearchController controller;
    static ResponseModel<DataModel> responseWithPage;
    static ResponseModel<DataModel> responseWithoutPage;

    @BeforeClass
    public static void setUp() throws Exception {
        query = "kang";
        page = "2";
        controller = new SearchController();

        CompletableFuture<ResponseModel<DataModel>> futureWithPage = controller.get(query, page);
        futureWithPage.thenAccept((result) -> responseWithPage = result);
        futureWithPage.join();

        CompletableFuture<ResponseModel<DataModel>> futureWithoutPage = controller.get(query, null);
        futureWithoutPage.thenAccept((result) -> responseWithoutPage = result);
        futureWithoutPage.join();
    }

    @Test
    public void withoutPageStatusEqualsTo200() {
        assertEquals(responseWithoutPage.getStatus(), "200");
    }

    @Test
    public void withoutPageMessageIsNotFail() {
        assertNotEquals(responseWithoutPage.getMessage(), ResponseMessages.FAIL);
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
        assertNotEquals(responseWithPage.getMessage(), ResponseMessages.FAIL);
    }

    @Test
    public void withPageDataIsNotNull() {
        assertNotNull(responseWithPage.getData());
    }
}