package searchengine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import searchengine.config.SitesList;
import searchengine.model.Page;
import searchengine.model.Site;
import searchengine.repositories.PageRepository;

import java.util.concurrent.RecursiveAction;

@Service
@RequiredArgsConstructor
public class IndexationService {

    private final PageRepository repository;
    private final SitesList sitesList;

//    public IndexationService(SitesList sitesList) {
//        this.sitesList = sitesList;
//    }

    public ResponseEntity startIndexing() {
        Site site = new Site();
        Page page = new Page();


        return new ResponseEntity(page, HttpStatus.OK);
    }

}
