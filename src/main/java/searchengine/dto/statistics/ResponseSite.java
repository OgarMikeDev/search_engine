package searchengine.dto.statistics;

import lombok.Data;
import searchengine.model.Enum;

@Data
public class ResponseSite {
    private int id;

    private Enum status;

    private long statusTime;

    private String lastError;

    private String url;

    private String name;
}
