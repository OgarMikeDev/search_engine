package searchengine.dto.statistics.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import searchengine.model.Enum;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseSite {

    private final Enum status;

    private final String url;

    private final String name;

    private final String lastError;
}
