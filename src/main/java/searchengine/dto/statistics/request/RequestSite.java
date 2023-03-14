package searchengine.dto.statistics.request;

import lombok.Data;
import searchengine.model.Enum;

import java.time.LocalDateTime;

@Data
public class RequestSite {
    public RequestSite(Enum status, String lastError, String url, String name) {
        this.status = status;
        this.lastError = lastError;
        this.url = url;
        this.name = name;
    }

    private Enum status;

    private String lastError;

    private String url;

    private String name;
}
