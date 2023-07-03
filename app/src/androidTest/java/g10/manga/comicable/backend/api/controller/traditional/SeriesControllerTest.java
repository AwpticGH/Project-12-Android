package g10.manga.comicable.backend.api.controller.traditional;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.series.DataModel;
import g10.manga.comicable.dictionary.api.ResponseMessages;

public class SeriesControllerTest {

    private static String series;
    private static SeriesController controller;
    private static ResponseModel<DataModel> response;

    @BeforeClass
    public static void beforeClass() throws Exception {
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