package searchengine.dto.statistics.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import searchengine.model.Enum;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseSite {
//    public ResponseSite(Enum status, String url, String name, String lastError) {
//        this.status = status;
//        this.url = url;
//        this.name = name;
//        this.lastError = lastError;
//    }

    private Enum status;

    private String url;

    private String name;

    private String lastError;
}
