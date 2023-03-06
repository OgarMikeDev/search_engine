package searchengine.services;

import org.springframework.stereotype.Service;
import searchengine.config.SitesList;

import java.util.concurrent.RecursiveAction;

@Service
public class IndexationService {
    private final SitesList sitesList;

    public IndexationService(SitesList sitesList) {
        this.sitesList = sitesList;
    }

}
