package g10.manga.comicable.backend.api.controller.traditional;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import g10.manga.comicable.backend.api.model.ResponseModel;
import g10.manga.comicable.backend.api.model.chapter.DataModel;
import g10.manga.comicable.dictionary.api.ResponseMessages;

public class ChapterControllerTest {

    private static String series;
    private static String chapter;
    private static ChapterController controller;
    private static ResponseModel<DataModel> response;

    @BeforeClass
    static public void beforeClass() throws Exception {
        series = "overgeared";
        chapter = "chapter-01";
        controller = new ChapterController();
        response = controller.get(series, chapter);
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