package searchengine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import searchengine.config.SitesList;
import searchengine.model.Page;
import searchengine.model.SiteEntity;

@Service
@RequiredArgsConstructor
public class IndexationService {
    private final SitesList sitesList;
    public ResponseEntity startIndexing() {
        SiteEntity site = new SiteEntity();
        Page page = new Page();


        return new ResponseEntity(page, HttpStatus.OK);
    }

}
