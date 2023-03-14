package searchengine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.fjp.Node;
import searchengine.fjp.UrlsContainer;
import searchengine.fjp.WebScraper;
import searchengine.model.Enum;
import searchengine.model.Site;
import searchengine.repositories.PageRepository;
import searchengine.repositories.SiteRepository;
import searchengine.services.StatisticsService;

import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "indexing-settings:sites:")
public class ApiController {

    private final StatisticsService statisticsService;

    private SiteRepository siteRepository;

    public ApiController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }

    @GetMapping("/startIndexing/{url}")
    public String startIndexing(@PathVariable String url) {

        Site site = new Site();
        int idSite = site.generatedId();
        site.setStatus(Enum.INDEXING);
        site.setStatusTime(LocalDateTime.now());
        site.setLastError("");
        site.setUrl(url);
        site.setName(url);

        siteRepository.save(site);

        UrlsContainer.setMainPageUrl(url);
        Node node = new ForkJoinPool()
                .invoke(new WebScraper(new Node(url)));

        return site.getUrl();
    }
}
