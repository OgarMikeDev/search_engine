package searchengine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
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
public class ApiController {

    private final StatisticsService service;

    public ApiController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(service.getStatistics());
    }

    @GetMapping("/startIndexing/{url}")
    @ConfigurationProperties(prefix = "indexing-settings")
    public String startIndexing(String url, String name) {
        service.createEntry(url, name);
        return null;
    }
}
