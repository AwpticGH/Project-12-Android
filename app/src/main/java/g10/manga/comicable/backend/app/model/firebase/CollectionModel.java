package g10.manga.comicable.backend.app.model.firebase;

import java.io.Serializable;

public class CollectionModel extends BaseModel implements Serializable {

    private String uid;
    // Series title
    private String title;
    // Series endpoint
    private String endpoint;
    // User uid
    private String user;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
