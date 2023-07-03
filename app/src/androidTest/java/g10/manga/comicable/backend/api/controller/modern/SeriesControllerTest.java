package g10.manga.comicable.backend.api.controller.modern;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import g10.manga.comicable.backend.api.controller.modern.SeriesController;
import g10.manga.comicable.dictionary.api.ResponseMessages;
import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;

public class SeriesControllerTest {

    static String series;
    static SeriesController controller;
    static ResponseModel<DataModel> response;

    @BeforeClass
    public static void setUp() throws Exception {
        series = "overgeared";
        controller = new SeriesController();
        response = controller.get(series);
    }

    @Test
    public void statusEqualsTo200() {
        assertEquals(response.getStatus(), "200");
    }

    @Test
    public void messageIsNotFail() {
        assertNotEquals(response.getMessage(), ResponseMessages.FAIL);
    }

    @Test
    public void dataIsNotNull() {
        assertNotNull(response.getData());
    }
}