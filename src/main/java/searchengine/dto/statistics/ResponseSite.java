package searchengine.dto.statistics;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import searchengine.model.Enum;

import java.time.LocalDateTime;

@Data
public class ResponseSite {
    public ResponseSite(int id, Enum status, LocalDateTime statusTime, String lastError, String url, String name) {
        this.id = id;
        this.status = status;
        this.statusTime = statusTime;
        this.lastError = lastError;
        this.url = url;
        this.name = name;
    }

    private int id;

    private Enum status;

    private LocalDateTime statusTime;

    private String lastError;

    private String url;

    private String name;
}
