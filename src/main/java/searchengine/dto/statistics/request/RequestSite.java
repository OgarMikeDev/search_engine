package searchengine.dto.statistics.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import searchengine.model.Enum;

import java.time.LocalDateTime;

@Data
public class RequestSite {

    private Enum status;

    private String lastError;

    private String url;

    private String name;
}
