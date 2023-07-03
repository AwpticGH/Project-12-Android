package g10.manga.comicable.backend.api.model.search;

import java.io.Serializable;

public class PaginationModel implements Serializable {

    private String name;
    private String endpoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
