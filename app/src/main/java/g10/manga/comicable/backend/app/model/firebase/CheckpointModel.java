package g10.manga.comicable.backend.app.model.firebase;

public class CheckpointModel extends BaseModel {

    // uid
    private String uid;
    // collection uid
    private String collection;
    // Chapter endpoint
    private String endpoint;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
