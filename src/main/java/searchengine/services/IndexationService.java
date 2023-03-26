package searchengine.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import searchengine.config.SitesList;
import searchengine.repositories.PageRepository;
import searchengine.services.fjp.Node;
import searchengine.services.fjp.UrlsContainer;
import searchengine.services.fjp.WebScraper;

import java.util.concurrent.ForkJoinPool;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class IndexationService {
//    private final SitesList sitesList;
    private final PageRepository pageRepository;


    public void startIndexing(String url) {
        UrlsContainer.setMainPageUrl(url);
        Node node = new ForkJoinPool()
                .invoke(new WebScraper(new Node(url)));
    }

}
